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
 * @param roleId * @param userId * @param expiresAt */
@Serializable
internal data class AdminRolesAssignRequest(
    @SerialName(value = "roleId") val roleId: kotlin.String,
    @SerialName(value = "userId") val userId: kotlin.String,
    @SerialName(value = "expiresAt") val expiresAt: kotlin.Int? = null,
)
