package dev.dimension.flare.data.datasource.mastodon

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import dev.dimension.flare.data.cache.DbPagingTimelineWithStatusView
import dev.dimension.flare.data.database.cache.CacheDatabase
import dev.dimension.flare.data.database.cache.mapper.Mastodon
import dev.dimension.flare.data.network.mastodon.MastodonService
import dev.dimension.flare.model.MicroBlogKey

@OptIn(ExperimentalPagingApi::class)
internal class SearchStatusPagingSource(
    private val service: MastodonService,
    private val database: CacheDatabase,
    private val accountKey: MicroBlogKey,
    private val pagingKey: String,
    private val query: String,
) : RemoteMediator<Int, DbPagingTimelineWithStatusView>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, DbPagingTimelineWithStatusView>,
    ): MediatorResult {
        return try {
            if (loadType == LoadType.REFRESH) {
                database.dbPagingTimelineQueries.deletePaging(accountKey, pagingKey)
            }
            val response =
                when (loadType) {
                    LoadType.PREPEND -> {
                        return MediatorResult.Success(
                            endOfPaginationReached = true,
                        )
                    }
                    LoadType.REFRESH -> {
                        service.searchV2(
                            query = query,
                            limit = state.config.pageSize,
                            type = "statuses",
                        )
                    }

                    LoadType.APPEND -> {
                        val lastItem =
                            state.lastItemOrNull()
                                ?: return MediatorResult.Success(
                                    endOfPaginationReached = true,
                                )
                        service.searchV2(
                            query = query,
                            limit = state.config.pageSize,
                            max_id = lastItem.timeline_status_key.id,
                            type = "statuses",
                        )
                    }
                }.statuses ?: emptyList()

            Mastodon.save(
                database = database,
                accountKey = accountKey,
                pagingKey = pagingKey,
                data = response,
            )

            MediatorResult.Success(
                endOfPaginationReached = response.isEmpty(),
            )
        } catch (e: Throwable) {
            MediatorResult.Error(e)
        }
    }
}
