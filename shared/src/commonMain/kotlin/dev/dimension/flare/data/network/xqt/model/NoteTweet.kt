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
 * @param isExpandable
 * @param noteTweetResults
 */
@Serializable
internal data class NoteTweet(
    @SerialName(value = "is_expandable")
    val isExpandable: kotlin.Boolean,
    @SerialName(value = "note_tweet_results")
    val noteTweetResults: NoteTweetResult,
)
