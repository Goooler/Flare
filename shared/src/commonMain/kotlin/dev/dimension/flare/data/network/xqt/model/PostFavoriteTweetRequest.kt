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
 * @param queryId
 * @param variables
 */
@Serializable
internal data class PostFavoriteTweetRequest(
    @SerialName(value = "queryId")
    val queryId: kotlin.String = "lI07N6Otwv1PhnEgXILM7A",
    @SerialName(value = "variables")
    val variables: PostCreateRetweetRequestVariables,
)
