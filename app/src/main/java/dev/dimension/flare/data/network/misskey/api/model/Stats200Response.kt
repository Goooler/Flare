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
 * @param notesCount * @param originalNotesCount * @param usersCount * @param originalUsersCount * @param instances * @param driveUsageLocal * @param driveUsageRemote */
@Serializable

data class Stats200Response(

    @SerialName(value = "notesCount") val notesCount: kotlin.Double,

    @SerialName(value = "originalNotesCount") val originalNotesCount: kotlin.Double,

    @SerialName(value = "usersCount") val usersCount: kotlin.Double,

    @SerialName(value = "originalUsersCount") val originalUsersCount: kotlin.Double,

    @SerialName(value = "instances") val instances: kotlin.Double,

    @SerialName(value = "driveUsageLocal") val driveUsageLocal: kotlin.Double,

    @SerialName(value = "driveUsageRemote") val driveUsageRemote: kotlin.Double

)
