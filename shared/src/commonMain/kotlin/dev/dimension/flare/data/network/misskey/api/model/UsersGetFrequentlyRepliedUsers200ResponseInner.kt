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
 * @param user * @param weight */
@Serializable
internal data class UsersGetFrequentlyRepliedUsers200ResponseInner(
    @SerialName(value = "user") val user: UserDetailed,
    @SerialName(value = "weight") val weight: kotlin.Double,
)
