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
 * @param roleId * @param name * @param description * @param color * @param iconUrl * @param target * @param condFormula * @param isPublic * @param isModerator * @param isAdministrator * @param asBadge * @param canEditMembersByModerator * @param displayOrder * @param policies * @param isExplorable */
@Serializable

data class AdminRolesUpdateRequest(

    @SerialName(value = "roleId") val roleId: kotlin.String,

    @SerialName(value = "name") val name: kotlin.String,

    @SerialName(value = "description") val description: kotlin.String,

    @SerialName(value = "color") val color: kotlin.String? = null,

    @SerialName(value = "iconUrl") val iconUrl: kotlin.String? = null,

    @SerialName(value = "target") val target: AdminRolesUpdateRequest.Target,

    @SerialName(value = "condFormula") val condFormula: kotlin.String,

    @SerialName(value = "isPublic") val isPublic: kotlin.Boolean,

    @SerialName(value = "isModerator") val isModerator: kotlin.Boolean,

    @SerialName(value = "isAdministrator") val isAdministrator: kotlin.Boolean,

    @SerialName(value = "asBadge") val asBadge: kotlin.Boolean,

    @SerialName(value = "canEditMembersByModerator") val canEditMembersByModerator: kotlin.Boolean,

    @SerialName(value = "displayOrder") val displayOrder: kotlin.Double,

    @SerialName(value = "policies") val policies: kotlin.String,

    @SerialName(value = "isExplorable") val isExplorable: kotlin.Boolean? = null

) {

    /**
     * *
     * Values: Manual,Conditional
     */
    @Serializable
    enum class Target(val value: kotlin.String) {
        @SerialName(value = "manual")
        Manual("manual"),

        @SerialName(value = "conditional")
        Conditional("conditional");
    }
}
