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
 * @param id * @param createdAt * @param muteeId * @param mutee */
@Serializable
internal data class RenoteMuting(
    @SerialName(value = "id") val id: kotlin.String,
    @SerialName(value = "createdAt") val createdAt: kotlin.String,
    @SerialName(value = "muteeId") val muteeId: kotlin.String,
    @SerialName(value = "mutee") val mutee: UserDetailed,
)
