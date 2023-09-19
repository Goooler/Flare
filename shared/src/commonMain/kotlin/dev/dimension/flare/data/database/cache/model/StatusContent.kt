package dev.dimension.flare.data.database.cache.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal sealed interface StatusContent {
    @Serializable
    @SerialName("mastodon")
    data class Mastodon(val data: dev.dimension.flare.data.network.mastodon.api.model.Status) :
        StatusContent

    @Serializable
    @SerialName("mastodon-notification")
    data class MastodonNotification(val data: dev.dimension.flare.data.network.mastodon.api.model.Notification) :
        StatusContent

    @Serializable
    @SerialName("misskey")
    data class Misskey(
        val data: dev.dimension.flare.data.network.misskey.api.model.Note,
    ) : StatusContent

    @Serializable
    @SerialName("misskey-notification")
    data class MisskeyNotification(
        val data: dev.dimension.flare.data.network.misskey.api.model.Notification,
    ) : StatusContent
//
//    @Serializable
//    @SerialName("bluesky")
//    data class Bluesky(val data: PostView) : StatusContent
//
//    @Serializable
//    @SerialName("bluesky-reason")
//    data class BlueskyReason(val data: FeedViewPostReasonUnion) : StatusContent
//
//    @Serializable
//    @SerialName("bluesky-notification")
//    data class BlueskyNotification(val data: app.bsky.notification.ListNotificationsNotification) :
//        StatusContent
}
