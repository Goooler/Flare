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

package dev.dimension.flare.data.network.xqt.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param aspectRatio
 * @param variants
 * @param durationMillis
 */
@Serializable
internal data class MediaVideoInfo(
    @SerialName(value = "aspect_ratio")
    val aspectRatio: kotlin.collections.List<kotlin.Int>,
    @SerialName(value = "variants")
    val variants: kotlin.collections.List<MediaVideoInfoVariant>,
    @SerialName(value = "duration_millis")
    val durationMillis: kotlin.Int? = null,
)
