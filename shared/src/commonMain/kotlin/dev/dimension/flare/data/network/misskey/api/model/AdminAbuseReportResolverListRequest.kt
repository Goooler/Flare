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
 * @param limit * @param sinceId * @param untilId */
@Serializable
data class AdminAbuseReportResolverListRequest(
    @SerialName(value = "limit") val limit: kotlin.Double? = (10).toDouble(),
    @SerialName(value = "sinceId") val sinceId: kotlin.String? = null,
    @SerialName(value = "untilId") val untilId: kotlin.String? = null,
)
