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
 * @param noteId * @param targetLang */
@Serializable
internal data class NotesTranslateRequest(
    @SerialName(value = "noteId") val noteId: kotlin.String,
    @SerialName(value = "targetLang") val targetLang: kotlin.String,
)
