/**
 *
 * Please note:
 * This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit this file manually.
 *
 */

@file:Suppress(
    "ArrayInDataClass",
    "EnumEntryName",
    "RemoveRedundantQualifierName",
    "UnusedImport",
)

package dev.dimension.flare.data.network.misskey.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param sort * @param limit * @param attachedToUserOnly * @param attachedToLocalUserOnly * @param attachedToRemoteUserOnly */
@Serializable
data class HashtagsListRequest(
    @SerialName(value = "sort") val sort: HashtagsListRequest.Sort,
    @SerialName(value = "limit") val limit: kotlin.Int? = 10,
    @SerialName(value = "attachedToUserOnly") val attachedToUserOnly: kotlin.Boolean? = false,
    @SerialName(value = "attachedToLocalUserOnly") val attachedToLocalUserOnly: kotlin.Boolean? = false,
    @SerialName(value = "attachedToRemoteUserOnly") val attachedToRemoteUserOnly: kotlin.Boolean? = false,
) {
    /**
     * *
     * Values: PlusMentionedUsers,MinusMentionedUsers,PlusMentionedLocalUsers,MinusMentionedLocalUsers,PlusMentionedRemoteUsers,MinusMentionedRemoteUsers,PlusAttachedUsers,MinusAttachedUsers,PlusAttachedLocalUsers,MinusAttachedLocalUsers,PlusAttachedRemoteUsers,MinusAttachedRemoteUsers
     */
    @Serializable
    enum class Sort(val value: kotlin.String) {
        @SerialName(value = "+mentionedUsers")
        PlusMentionedUsers("+mentionedUsers"),

        @SerialName(value = "-mentionedUsers")
        MinusMentionedUsers("-mentionedUsers"),

        @SerialName(value = "+mentionedLocalUsers")
        PlusMentionedLocalUsers("+mentionedLocalUsers"),

        @SerialName(value = "-mentionedLocalUsers")
        MinusMentionedLocalUsers("-mentionedLocalUsers"),

        @SerialName(value = "+mentionedRemoteUsers")
        PlusMentionedRemoteUsers("+mentionedRemoteUsers"),

        @SerialName(value = "-mentionedRemoteUsers")
        MinusMentionedRemoteUsers("-mentionedRemoteUsers"),

        @SerialName(value = "+attachedUsers")
        PlusAttachedUsers("+attachedUsers"),

        @SerialName(value = "-attachedUsers")
        MinusAttachedUsers("-attachedUsers"),

        @SerialName(value = "+attachedLocalUsers")
        PlusAttachedLocalUsers("+attachedLocalUsers"),

        @SerialName(value = "-attachedLocalUsers")
        MinusAttachedLocalUsers("-attachedLocalUsers"),

        @SerialName(value = "+attachedRemoteUsers")
        PlusAttachedRemoteUsers("+attachedRemoteUsers"),

        @SerialName(value = "-attachedRemoteUsers")
        MinusAttachedRemoteUsers("-attachedRemoteUsers"),
    }
}
