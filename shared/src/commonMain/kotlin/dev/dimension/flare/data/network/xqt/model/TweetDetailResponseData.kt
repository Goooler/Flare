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
 * @param threadedConversationWithInjectionsV2
 */
@Serializable
internal data class TweetDetailResponseData(
    @SerialName(value = "threaded_conversation_with_injections_v2")
    val threadedConversationWithInjectionsV2: Timeline,
)
