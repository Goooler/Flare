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
 * @param id * @param app * @param token */
@Serializable

data class AuthSessionShow200Response(

    @SerialName(value = "id") val id: kotlin.String,

    @SerialName(value = "app") val app: App,

    @SerialName(value = "token") val token: kotlin.String

)
