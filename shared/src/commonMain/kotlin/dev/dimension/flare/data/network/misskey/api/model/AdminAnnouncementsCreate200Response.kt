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
 * @param id * @param createdAt * @param updatedAt * @param title * @param text * @param imageUrl * @param displayOrder * @param userId * @param closeDuration */
@Serializable
data class AdminAnnouncementsCreate200Response(
    @SerialName(value = "id") val id: kotlin.String,
    @SerialName(value = "createdAt") val createdAt: kotlin.String,
    @SerialName(value = "updatedAt") val updatedAt: kotlin.String? = null,
    @SerialName(value = "title") val title: kotlin.String,
    @SerialName(value = "text") val text: kotlin.String,
    @SerialName(value = "imageUrl") val imageUrl: kotlin.String? = null,
    @SerialName(value = "displayOrder") val displayOrder: kotlin.Double,
    @SerialName(value = "userId") val userId: kotlin.String? = null,
    @SerialName(value = "closeDuration") val closeDuration: kotlin.Double,
)
