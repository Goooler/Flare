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
 * @param localCount * @param remoteCount */
@Serializable
internal data class ChartsUserReactions200Response(
    @SerialName(value = "local.count") val localCount: kotlin.collections.List<kotlin.Double>,
    @SerialName(value = "remote.count") val remoteCount: kotlin.collections.List<kotlin.Double>,
)
