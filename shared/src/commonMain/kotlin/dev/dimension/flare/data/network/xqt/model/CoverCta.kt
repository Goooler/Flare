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
 * @param callbacks
 * @param clientEventInfo
 * @param ctaBehavior
 * @param text
 * @param buttonStyle
 */
@Serializable
internal data class CoverCta(
    @SerialName(value = "callbacks")
    val callbacks: kotlin.collections.List<Callback>,
    @SerialName(value = "clientEventInfo")
    val clientEventInfo: CtaClientEventInfo,
    @SerialName(value = "ctaBehavior")
    val ctaBehavior: TimelineCoverBehavior,
    @SerialName(value = "Text")
    val text: kotlin.String? = null,
    @SerialName(value = "buttonStyle")
    val buttonStyle: CoverCta.ButtonStyle? = null,
) {
    /**
     *
     *
     * Values: primary
     */
    @Serializable
    enum class ButtonStyle(val value: kotlin.String) {
        @SerialName(value = "Primary")
        primary("Primary"),
    }
}
