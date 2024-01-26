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
 * @param id * @param firstRetrievedAt * @param host * @param usersCount * @param notesCount * @param followingCount * @param followersCount * @param isNotResponding * @param isSuspended * @param isBlocked * @param softwareName * @param softwareVersion * @param openRegistrations * @param name * @param description * @param maintainerName * @param maintainerEmail * @param iconUrl * @param faviconUrl * @param themeColor * @param infoUpdatedAt */
@Serializable
internal data class FederationInstance(
    @SerialName(value = "id") val id: kotlin.String,
    @SerialName(value = "firstRetrievedAt") val firstRetrievedAt: kotlin.String,
    @SerialName(value = "host") val host: kotlin.String,
    @SerialName(value = "usersCount") val usersCount: kotlin.Double,
    @SerialName(value = "notesCount") val notesCount: kotlin.Double,
    @SerialName(value = "followingCount") val followingCount: kotlin.Double,
    @SerialName(value = "followersCount") val followersCount: kotlin.Double,
    @SerialName(value = "isNotResponding") val isNotResponding: kotlin.Boolean,
    @SerialName(value = "isSuspended") val isSuspended: kotlin.Boolean,
    @SerialName(value = "isBlocked") val isBlocked: kotlin.Boolean,
    @SerialName(value = "softwareName") val softwareName: kotlin.String? = null,
    @SerialName(value = "softwareVersion") val softwareVersion: kotlin.String? = null,
    @SerialName(value = "openRegistrations") val openRegistrations: kotlin.Boolean? = null,
    @SerialName(value = "name") val name: kotlin.String? = null,
    @SerialName(value = "description") val description: kotlin.String? = null,
    @SerialName(value = "maintainerName") val maintainerName: kotlin.String? = null,
    @SerialName(value = "maintainerEmail") val maintainerEmail: kotlin.String? = null,
    @SerialName(value = "iconUrl") val iconUrl: kotlin.String? = null,
    @SerialName(value = "faviconUrl") val faviconUrl: kotlin.String? = null,
    @SerialName(value = "themeColor") val themeColor: kotlin.String? = null,
    @SerialName(value = "infoUpdatedAt") val infoUpdatedAt: kotlin.String?,
)
