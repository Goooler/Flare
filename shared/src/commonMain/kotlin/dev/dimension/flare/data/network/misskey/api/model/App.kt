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
 * @param id * @param name * @param callbackUrl * @param permission * @param secret * @param isAuthorized */
@Serializable
internal data class App(
    @SerialName(value = "id") val id: kotlin.String,
    @SerialName(value = "name") val name: kotlin.String,
    @SerialName(value = "callbackUrl") val callbackUrl: kotlin.String? = null,
    @SerialName(value = "permission") val permission: kotlin.collections.List<kotlin.String>,
    @SerialName(value = "secret") val secret: kotlin.String? = null,
    @SerialName(value = "isAuthorized") val isAuthorized: kotlin.Boolean? = null,
)
