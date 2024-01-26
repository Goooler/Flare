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
 * @param local * @param reply * @param renote * @param withFiles * @param poll * @param limit * @param sinceId * @param untilId */
@Serializable
internal data class NotesRequest(
    @SerialName(value = "local") val local: kotlin.Boolean? = false,
    @SerialName(value = "reply") val reply: kotlin.Boolean? = null,
    @SerialName(value = "renote") val renote: kotlin.Boolean? = null,
    @SerialName(value = "withFiles") val withFiles: kotlin.Boolean? = null,
    @SerialName(value = "poll") val poll: kotlin.Boolean? = null,
    @SerialName(value = "limit") val limit: kotlin.Int? = 10,
    @SerialName(value = "sinceId") val sinceId: kotlin.String? = null,
    @SerialName(value = "untilId") val untilId: kotlin.String? = null,
)
