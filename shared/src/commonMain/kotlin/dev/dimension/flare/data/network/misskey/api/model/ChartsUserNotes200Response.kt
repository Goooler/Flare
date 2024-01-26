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
 * @param total * @param inc * @param dec * @param diffsNormal * @param diffsReply * @param diffsRenote * @param diffsWithFile */
@Serializable
internal data class ChartsUserNotes200Response(
    @SerialName(value = "total") val total: kotlin.collections.List<kotlin.Double>,
    @SerialName(value = "inc") val inc: kotlin.collections.List<kotlin.Double>,
    @SerialName(value = "dec") val dec: kotlin.collections.List<kotlin.Double>,
    @SerialName(value = "diffs.normal") val diffsNormal: kotlin.collections.List<kotlin.Double>,
    @SerialName(value = "diffs.reply") val diffsReply: kotlin.collections.List<kotlin.Double>,
    @SerialName(value = "diffs.renote") val diffsRenote: kotlin.collections.List<kotlin.Double>,
    @SerialName(value = "diffs.withFile") val diffsWithFile: kotlin.collections.List<kotlin.Double>,
)
