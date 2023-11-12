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
 * @param id * @param code * @param expiresAt * @param createdAt * @param createdBy * @param usedBy * @param usedAt * @param used */
@Serializable
data class InviteCode(
    @SerialName(value = "id") val id: kotlin.String,
    @SerialName(value = "code") val code: kotlin.String,
    @SerialName(value = "expiresAt") val expiresAt: kotlin.String? = null,
    @SerialName(value = "createdAt") val createdAt: kotlin.String,
    @SerialName(value = "createdBy") val createdBy: UserLite,
    @SerialName(value = "usedBy") val usedBy: UserLite,
    @SerialName(value = "usedAt") val usedAt: kotlin.String? = null,
    @SerialName(value = "used") val used: kotlin.Boolean,
)
