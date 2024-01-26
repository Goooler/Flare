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

package dev.dimension.flare.data.network.xqt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param content
 * @param entryId
 * @param sortIndex
 */
@Serializable
internal data class TimelineAddEntry(
    @SerialName(value = "content")
    val content: ContentUnion,
    @SerialName(value = "entryId")
    val entryId: kotlin.String,
    @SerialName(value = "sortIndex")
    val sortIndex: kotlin.String,
)
