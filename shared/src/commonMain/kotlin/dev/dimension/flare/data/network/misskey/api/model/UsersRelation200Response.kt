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
 * @param id * @param isFollowing * @param hasPendingFollowRequestFromYou * @param hasPendingFollowRequestToYou * @param isFollowed * @param isBlocking * @param isBlocked * @param isMuted * @param isRenoteMuted */
@Serializable
internal data class UsersRelation200Response(
    @SerialName(value = "id") val id: kotlin.String,
    @SerialName(value = "isFollowing") val isFollowing: kotlin.Boolean,
    @SerialName(value = "hasPendingFollowRequestFromYou") val hasPendingFollowRequestFromYou: kotlin.Boolean,
    @SerialName(value = "hasPendingFollowRequestToYou") val hasPendingFollowRequestToYou: kotlin.Boolean,
    @SerialName(value = "isFollowed") val isFollowed: kotlin.Boolean,
    @SerialName(value = "isBlocking") val isBlocking: kotlin.Boolean,
    @SerialName(value = "isBlocked") val isBlocked: kotlin.Boolean,
    @SerialName(value = "isMuted") val isMuted: kotlin.Boolean,
    @SerialName(value = "isRenoteMuted") val isRenoteMuted: kotlin.Boolean,
)
