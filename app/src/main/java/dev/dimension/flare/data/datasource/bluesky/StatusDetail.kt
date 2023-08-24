package dev.dimension.flare.data.datasource.bluesky

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import app.bsky.feed.GetPostThreadQueryParams
import app.bsky.feed.GetPostThreadResponseThreadUnion
import app.bsky.feed.GetPostsQueryParams
import app.bsky.feed.ThreadViewPostParentUnion
import app.bsky.feed.ThreadViewPostReplieUnion
import com.moriatsushi.koject.compose.rememberInject
import dev.dimension.flare.data.database.cache.CacheDatabase
import dev.dimension.flare.data.network.bluesky.getService
import dev.dimension.flare.data.repository.app.UiAccount
import dev.dimension.flare.model.MicroBlogKey
import dev.dimension.flare.ui.model.UiStatus
import dev.dimension.flare.ui.model.mapper.toUi
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.Flow
import sh.christian.ozone.api.AtUri

// @OptIn(ExperimentalPagingApi::class)
// internal class StatusDetailRemoteMediator(
//    private val statusKey: MicroBlogKey,
//    private val account: UiAccount.Bluesky,
//    private val database: CacheDatabase,
//    private val accountKey: MicroBlogKey,
//    private val pagingKey: String,
//    private val statusOnly: Boolean
// ) : RemoteMediator<Int, DbPagingTimelineWithStatus>() {
//    override suspend fun load(
//        loadType: LoadType,
//        state: PagingState<Int, DbPagingTimelineWithStatus>
//    ): MediatorResult {
//        val service = account.getService()
//        return try {
//            if (loadType != LoadType.REFRESH) {
//                return MediatorResult.Success(
//                    endOfPaginationReached = true
//                )
//            }
//            if (!database.pagingTimelineDao().exists(pagingKey, accountKey)) {
//                database.statusDao().getStatus(statusKey, accountKey)?.let {
//                    database.pagingTimelineDao()
//                        .insertAll(
//                            listOf(
//                                DbPagingTimeline(
//                                    _id = UUID.randomUUID().toString(),
//                                    accountKey = accountKey,
//                                    statusKey = statusKey,
//                                    pagingKey = pagingKey,
//                                    sortId = 0
//                                )
//                            )
//                        )
//                }
//            }
//            val result = if (statusOnly) {
//                val current = service.getPosts(
//                    GetPostsQueryParams(
//                        persistentListOf(AtUri(statusKey.id))
//                    )
//                ).requireResponse().posts.firstOrNull()
//                listOfNotNull(current)
//            } else {
//                val context = service.getPostThread(
//                    GetPostThreadQueryParams(
//                        AtUri(statusKey.id)
//                    )
//                ).requireResponse()
//                when (val thread = context.thread) {
//                    is GetPostThreadResponseThreadUnion.ThreadViewPost -> {
//                        val parent = when (val value = thread.value.parent) {
//                            is ThreadViewPostParentUnion.ThreadViewPost -> value.value
//                            else -> null
//                        }
//                        val replies = thread.value.replies.mapNotNull {
//                            when (it) {
//                                is ThreadViewPostReplieUnion.ThreadViewPost -> it.value.post
//                                else -> null
//                            }
//                        }
//                        listOfNotNull(parent?.post) + thread.value.post + replies
//
//                    }
//                    else -> emptyList()
//                }
//            }
//
//            with(database) {
//                with(result) {
//                    savePost(accountKey, pagingKey) {
//                        -result.indexOf(it).toLong()
//                    }
//                }
//            }
//            MediatorResult.Success(
//                endOfPaginationReached = true
//            )
//        } catch (e: IOException) {
//            MediatorResult.Error(e)
//        } catch (e: HttpException) {
//            MediatorResult.Error(e)
//        }
//    }
// }

private class StatusDetailPagingSource(
    private val statusOnly: Boolean,
    private val account: UiAccount.Bluesky,
    private val statusKey: MicroBlogKey
) : PagingSource<String, UiStatus>() {
    override fun getRefreshKey(state: PagingState<String, UiStatus>): String? {
        return null
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, UiStatus> {
        try {
            val service = account.getService()
            val response = if (statusOnly) {
                val current = service.getPosts(
                    GetPostsQueryParams(
                        persistentListOf(AtUri(statusKey.id))
                    )
                ).requireResponse().posts.firstOrNull()
                listOfNotNull(current)
            } else {
                val context = service.getPostThread(
                    GetPostThreadQueryParams(
                        AtUri(statusKey.id)
                    )
                ).requireResponse()
                when (val thread = context.thread) {
                    is GetPostThreadResponseThreadUnion.ThreadViewPost -> {
                        val parent = when (val value = thread.value.parent) {
                            is ThreadViewPostParentUnion.ThreadViewPost -> value.value
                            else -> null
                        }
                        val replies = thread.value.replies.mapNotNull {
                            when (it) {
                                is ThreadViewPostReplieUnion.ThreadViewPost -> it.value.post
                                else -> null
                            }
                        }
                        listOfNotNull(parent?.post) + thread.value.post + replies
                    }
                    else -> emptyList()
                }
            }

            return LoadResult.Page(
                data = response.map {
                    it.toUi(account.accountKey)
                },
                prevKey = null,
                nextKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(e)
        }
    }
}

@OptIn(ExperimentalPagingApi::class)
@Composable
internal fun statusOnlyDataSource(
    account: UiAccount.Bluesky,
    statusKey: MicroBlogKey,
    pagingKey: String = "status_only_$statusKey",
    database: CacheDatabase = rememberInject()
): Flow<PagingData<UiStatus>> {
    return remember(
        account.accountKey,
        statusKey
    ) {
        Pager(
            config = PagingConfig(pageSize = 20)
        ) {
            StatusDetailPagingSource(
                statusOnly = true,
                account = account,
                statusKey = statusKey
            )
        }.flow
    }
}

@OptIn(ExperimentalPagingApi::class)
@Composable
internal fun statusDataSource(
    account: UiAccount.Bluesky,
    statusKey: MicroBlogKey,
    pageSize: Int = 20,
    pagingKey: String = "status_$statusKey",
    database: CacheDatabase = rememberInject()
): Flow<PagingData<UiStatus>> {
    return remember(
        account.accountKey,
        statusKey
    ) {
        Pager(
            config = PagingConfig(pageSize = pageSize)
        ) {
            StatusDetailPagingSource(
                statusOnly = false,
                account = account,
                statusKey = statusKey
            )
        }.flow
    }
}
