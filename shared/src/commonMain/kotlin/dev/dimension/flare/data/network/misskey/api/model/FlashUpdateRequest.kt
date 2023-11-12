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
 * @param flashId * @param title * @param summary * @param script * @param permissions */
@Serializable
data class FlashUpdateRequest(
    @SerialName(value = "flashId") val flashId: kotlin.String,
    @SerialName(value = "title") val title: kotlin.String,
    @SerialName(value = "summary") val summary: kotlin.String,
    @SerialName(value = "script") val script: kotlin.String,
    @SerialName(value = "permissions") val permissions: kotlin.collections.List<kotlin.String>,
)
