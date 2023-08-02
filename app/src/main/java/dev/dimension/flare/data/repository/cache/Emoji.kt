package dev.dimension.flare.data.repository.cache

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.moriatsushi.koject.inject
import dev.dimension.flare.common.Cacheable
import dev.dimension.flare.common.CacheableState
import dev.dimension.flare.common.collectAsState
import dev.dimension.flare.data.database.cache.CacheDatabase
import dev.dimension.flare.data.database.cache.mapper.toDb
import dev.dimension.flare.data.repository.app.UiAccount
import dev.dimension.flare.ui.model.UiEmoji
import dev.dimension.flare.ui.model.mapper.toUi
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.mapNotNull

@Composable
internal fun mastodonEmojiProvider(
    account: UiAccount.Mastodon,
    cacheDatabase: CacheDatabase = inject()
): CacheableState<ImmutableList<UiEmoji>> {
    return remember(account.accountKey) {
        Cacheable(
            fetchSource = {
                val emojis = account.service.emojis()
                cacheDatabase.emojiDao().insertAll(listOf(emojis.toDb(account.accountKey.host)))
            },
            cacheSource = {
                cacheDatabase.emojiDao().getEmoji(account.accountKey.host)
                    .mapNotNull { it?.toUi()?.toImmutableList() }
            }
        )
    }.collectAsState()
}
