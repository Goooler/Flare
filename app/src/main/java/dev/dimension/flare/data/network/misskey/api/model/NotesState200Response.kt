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
    "UnusedImport"
)

package dev.dimension.flare.data.network.misskey.api.model

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * *
 * @param isFavorited * @param isMutedThread */
@Serializable

data class NotesState200Response(

    @SerialName(value = "isFavorited") val isFavorited: kotlin.Boolean,

    @SerialName(value = "isMutedThread") val isMutedThread: kotlin.Boolean

)
