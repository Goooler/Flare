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
 * @param id * @param createdAt * @param name * @param parentId * @param foldersCount * @param filesCount * @param parent */
@Serializable

data class DriveFolder(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "createdAt") val createdAt: kotlin.String,

    @SerialName(value = "name") val name: kotlin.String,

    @SerialName(value = "parentId") val parentId: kotlin.String? = null,

    @SerialName(value = "foldersCount") val foldersCount: kotlin.Double? = null,

    @SerialName(value = "filesCount") val filesCount: kotlin.Double? = null,

    @SerialName(value = "parent") val parent: DriveFolder? = null

)
