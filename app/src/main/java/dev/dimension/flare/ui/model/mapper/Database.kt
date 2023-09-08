package dev.dimension.flare.ui.model.mapper

import dev.dimension.flare.data.database.cache.model.DbPagingTimelineWithStatus
import dev.dimension.flare.data.database.cache.model.DbUser
import dev.dimension.flare.data.database.cache.model.StatusContent
import dev.dimension.flare.data.database.cache.model.UserContent
import dev.dimension.flare.ui.model.UiStatus
import dev.dimension.flare.ui.model.UiUser

internal fun DbPagingTimelineWithStatus.toUi(): UiStatus {
    return when (val status = status.status.data.content) {
        is StatusContent.Mastodon -> status.data.toUi(
            accountKey = timeline.accountKey,
        )

        is StatusContent.MastodonNotification -> status.data.toUi(
            accountKey = timeline.accountKey,
        )

        is StatusContent.Misskey -> status.data.toUi(
            accountKey = timeline.accountKey,
        )

        is StatusContent.MisskeyNotification -> status.data.toUi(
            accountKey = timeline.accountKey,
        )
        is StatusContent.Bluesky -> status.data.toUi(
            accountKey = timeline.accountKey,
        )
        is StatusContent.BlueskyNotification -> status.data.toUi(
            accountKey = timeline.accountKey,
        )
        is StatusContent.BlueskyReason -> status.data.toUi(
            accountKey = timeline.accountKey,
            data = this,
        )
    }
}

internal fun DbUser.toUi(): UiUser {
    return when (val user = content) {
        is UserContent.Mastodon -> user.data.toUi(host = userKey.host)

        is UserContent.Misskey -> user.data.toUi(
            accountHost = userKey.host,
        )

        is UserContent.MisskeyLite -> user.data.toUi(
            accountHost = userKey.host,
        )

        is UserContent.Bluesky -> user.data.toUi(
            accountHost = userKey.host,
        )
        is UserContent.BlueskyLite -> user.data.toUi(
            accountHost = userKey.host,
        )
    }
}
