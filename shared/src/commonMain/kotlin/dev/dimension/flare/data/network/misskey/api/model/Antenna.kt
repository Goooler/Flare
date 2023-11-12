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
 * @param id * @param createdAt * @param name * @param keywords * @param excludeKeywords * @param src * @param userListId * @param users * @param caseSensitive * @param notify * @param withReplies * @param withFile * @param isActive * @param hasUnreadNote */
@Serializable
data class Antenna(
    @SerialName(value = "id") val id: kotlin.String,
    @SerialName(value = "createdAt") val createdAt: kotlin.String,
    @SerialName(value = "name") val name: kotlin.String,
    @SerialName(value = "keywords") val keywords: kotlin.collections.List<kotlin.collections.List<kotlin.String>>,
    @SerialName(value = "excludeKeywords") val excludeKeywords: kotlin.collections.List<kotlin.collections.List<kotlin.String>>,
    @SerialName(value = "src") val src: Antenna.Src,
    @SerialName(value = "userListId") val userListId: kotlin.String? = null,
    @SerialName(value = "users") val users: kotlin.collections.List<kotlin.String>,
    @SerialName(value = "caseSensitive") val caseSensitive: kotlin.Boolean = false,
    @SerialName(value = "notify") val notify: kotlin.Boolean,
    @SerialName(value = "withReplies") val withReplies: kotlin.Boolean = false,
    @SerialName(value = "withFile") val withFile: kotlin.Boolean,
    @SerialName(value = "isActive") val isActive: kotlin.Boolean,
    @SerialName(value = "hasUnreadNote") val hasUnreadNote: kotlin.Boolean = false,
) {
    /**
     * *
     * Values: Home,All,Users,List
     */
    @Serializable
    enum class Src(val value: kotlin.String) {
        @SerialName(value = "home")
        Home("home"),

        @SerialName(value = "all")
        All("all"),

        @SerialName(value = "users")
        Users("users"),

        @SerialName(value = "list")
        List("list"),
    }
}
