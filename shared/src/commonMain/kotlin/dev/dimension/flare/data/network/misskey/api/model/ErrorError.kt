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
 * An error object.
 *
 * @param code An error code. Unique within the endpoint.
 * @param message An error message.
 * @param id An error ID. This ID is static.
 */
@Serializable
internal data class ErrorError(
    // An error code. Unique within the endpoint.
    @SerialName(value = "code") val code: kotlin.String,
    // An error message.
    @SerialName(value = "message") val message: kotlin.String,
    // An error ID. This ID is static.
    @SerialName(value = "id") val id: kotlin.String,
)
