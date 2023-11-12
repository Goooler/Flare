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
 * @param id * @param name * @param username * @param host The local host is represented with `null`.
 * @param avatarUrl * @param avatarBlurhash * @param onlineStatus * @param isAdmin * @param isModerator * @param isBot * @param isCat */
@Serializable
data class UserLite(
    @SerialName(value = "id") val id: kotlin.String,
    @SerialName(value = "name") val name: kotlin.String? = null,
    @SerialName(value = "username") val username: kotlin.String,
    // The local host is represented with `null`.
    @SerialName(value = "host") val host: kotlin.String? = null,
    @SerialName(value = "avatarUrl") val avatarUrl: kotlin.String? = null,
    @SerialName(value = "avatarBlurhash") val avatarBlurhash: kotlin.String? = null,
    @SerialName(value = "onlineStatus") val onlineStatus: UserLite.OnlineStatus? = null,
    @SerialName(value = "isAdmin") val isAdmin: kotlin.Boolean? = false,
    @SerialName(value = "isModerator") val isModerator: kotlin.Boolean? = false,
    @SerialName(value = "isBot") val isBot: kotlin.Boolean? = null,
    @SerialName(value = "isCat") val isCat: kotlin.Boolean? = null,
) {
    /**
     * *
     * Values: Unknown,Online,Active,Offline
     */
    @Serializable
    enum class OnlineStatus(val value: kotlin.String) {
        @SerialName(value = "unknown")
        Unknown("unknown"),

        @SerialName(value = "online")
        Online("online"),

        @SerialName(value = "active")
        Active("active"),

        @SerialName(value = "offline")
        Offline("offline"),
    }
}
