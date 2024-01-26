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
 * @param disableRegistration * @param pinnedUsers * @param hiddenTags * @param blockedHosts * @param sensitiveWords * @param themeColor * @param mascotImageUrl * @param bannerUrl * @param serverErrorImageUrl * @param infoImageUrl * @param notFoundImageUrl * @param iconUrl * @param backgroundImageUrl * @param logoImageUrl * @param name * @param description * @param defaultLightTheme * @param defaultDarkTheme * @param cacheRemoteFiles * @param cacheRemoteSensitiveFiles * @param emailRequiredForSignup * @param enableHcaptcha * @param hcaptchaSiteKey * @param hcaptchaSecretKey * @param enableRecaptcha * @param recaptchaSiteKey * @param recaptchaSecretKey * @param enableTurnstile * @param turnstileSiteKey * @param turnstileSecretKey * @param sensitiveMediaDetection * @param sensitiveMediaDetectionSensitivity * @param setSensitiveFlagAutomatically * @param enableSensitiveMediaDetectionForVideos * @param proxyAccountId * @param maintainerName * @param maintainerEmail * @param langs * @param summalyProxy * @param deeplAuthKey * @param deeplIsPro * @param enableEmail * @param email * @param smtpSecure * @param smtpHost * @param smtpPort * @param smtpUser * @param smtpPass * @param enableServiceWorker * @param swPublicKey * @param swPrivateKey * @param tosUrl * @param repositoryUrl * @param feedbackUrl * @param useObjectStorage * @param objectStorageBaseUrl * @param objectStorageBucket * @param objectStoragePrefix * @param objectStorageEndpoint * @param objectStorageRegion * @param objectStoragePort * @param objectStorageAccessKey * @param objectStorageSecretKey * @param objectStorageUseSSL * @param objectStorageUseProxy * @param objectStorageSetPublicRead * @param objectStorageS3ForcePathStyle * @param enableIpLogging * @param enableActiveEmailValidation * @param enableChartsForRemoteUser * @param enableChartsForFederatedInstances * @param enableServerMachineStats * @param enableIdenticonGeneration * @param serverRules * @param preservedUsernames */
@Serializable
internal data class AdminUpdateMetaRequest(
    @SerialName(value = "disableRegistration") val disableRegistration: kotlin.Boolean? = null,
    @SerialName(value = "pinnedUsers") val pinnedUsers: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "hiddenTags") val hiddenTags: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "blockedHosts") val blockedHosts: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "sensitiveWords") val sensitiveWords: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "themeColor") val themeColor: kotlin.String? = null,
    @SerialName(value = "mascotImageUrl") val mascotImageUrl: kotlin.String? = null,
    @SerialName(value = "bannerUrl") val bannerUrl: kotlin.String? = null,
    @SerialName(value = "serverErrorImageUrl") val serverErrorImageUrl: kotlin.String? = null,
    @SerialName(value = "infoImageUrl") val infoImageUrl: kotlin.String? = null,
    @SerialName(value = "notFoundImageUrl") val notFoundImageUrl: kotlin.String? = null,
    @SerialName(value = "iconUrl") val iconUrl: kotlin.String? = null,
    @SerialName(value = "backgroundImageUrl") val backgroundImageUrl: kotlin.String? = null,
    @SerialName(value = "logoImageUrl") val logoImageUrl: kotlin.String? = null,
    @SerialName(value = "name") val name: kotlin.String? = null,
    @SerialName(value = "description") val description: kotlin.String? = null,
    @SerialName(value = "defaultLightTheme") val defaultLightTheme: kotlin.String? = null,
    @SerialName(value = "defaultDarkTheme") val defaultDarkTheme: kotlin.String? = null,
    @SerialName(value = "cacheRemoteFiles") val cacheRemoteFiles: kotlin.Boolean? = null,
    @SerialName(value = "cacheRemoteSensitiveFiles") val cacheRemoteSensitiveFiles: kotlin.Boolean? = null,
    @SerialName(value = "emailRequiredForSignup") val emailRequiredForSignup: kotlin.Boolean? = null,
    @SerialName(value = "enableHcaptcha") val enableHcaptcha: kotlin.Boolean? = null,
    @SerialName(value = "hcaptchaSiteKey") val hcaptchaSiteKey: kotlin.String? = null,
    @SerialName(value = "hcaptchaSecretKey") val hcaptchaSecretKey: kotlin.String? = null,
    @SerialName(value = "enableRecaptcha") val enableRecaptcha: kotlin.Boolean? = null,
    @SerialName(value = "recaptchaSiteKey") val recaptchaSiteKey: kotlin.String? = null,
    @SerialName(value = "recaptchaSecretKey") val recaptchaSecretKey: kotlin.String? = null,
    @SerialName(value = "enableTurnstile") val enableTurnstile: kotlin.Boolean? = null,
    @SerialName(value = "turnstileSiteKey") val turnstileSiteKey: kotlin.String? = null,
    @SerialName(value = "turnstileSecretKey") val turnstileSecretKey: kotlin.String? = null,
    @SerialName(value = "sensitiveMediaDetection") val sensitiveMediaDetection: AdminUpdateMetaRequest.SensitiveMediaDetection? = null,
    @SerialName(value = "sensitiveMediaDetectionSensitivity") val sensitiveMediaDetectionSensitivity:
        AdminUpdateMetaRequest.SensitiveMediaDetectionSensitivity? = null,
    @SerialName(value = "setSensitiveFlagAutomatically") val setSensitiveFlagAutomatically: kotlin.Boolean? = null,
    @SerialName(value = "enableSensitiveMediaDetectionForVideos") val enableSensitiveMediaDetectionForVideos: kotlin.Boolean? = null,
    @SerialName(value = "proxyAccountId") val proxyAccountId: kotlin.String? = null,
    @SerialName(value = "maintainerName") val maintainerName: kotlin.String? = null,
    @SerialName(value = "maintainerEmail") val maintainerEmail: kotlin.String? = null,
    @SerialName(value = "langs") val langs: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "summalyProxy") val summalyProxy: kotlin.String? = null,
    @SerialName(value = "deeplAuthKey") val deeplAuthKey: kotlin.String? = null,
    @SerialName(value = "deeplIsPro") val deeplIsPro: kotlin.Boolean? = null,
    @SerialName(value = "enableEmail") val enableEmail: kotlin.Boolean? = null,
    @SerialName(value = "email") val email: kotlin.String? = null,
    @SerialName(value = "smtpSecure") val smtpSecure: kotlin.Boolean? = null,
    @SerialName(value = "smtpHost") val smtpHost: kotlin.String? = null,
    @SerialName(value = "smtpPort") val smtpPort: kotlin.Int? = null,
    @SerialName(value = "smtpUser") val smtpUser: kotlin.String? = null,
    @SerialName(value = "smtpPass") val smtpPass: kotlin.String? = null,
    @SerialName(value = "enableServiceWorker") val enableServiceWorker: kotlin.Boolean? = null,
    @SerialName(value = "swPublicKey") val swPublicKey: kotlin.String? = null,
    @SerialName(value = "swPrivateKey") val swPrivateKey: kotlin.String? = null,
    @SerialName(value = "tosUrl") val tosUrl: kotlin.String? = null,
    @SerialName(value = "repositoryUrl") val repositoryUrl: kotlin.String? = null,
    @SerialName(value = "feedbackUrl") val feedbackUrl: kotlin.String? = null,
    @SerialName(value = "useObjectStorage") val useObjectStorage: kotlin.Boolean? = null,
    @SerialName(value = "objectStorageBaseUrl") val objectStorageBaseUrl: kotlin.String? = null,
    @SerialName(value = "objectStorageBucket") val objectStorageBucket: kotlin.String? = null,
    @SerialName(value = "objectStoragePrefix") val objectStoragePrefix: kotlin.String? = null,
    @SerialName(value = "objectStorageEndpoint") val objectStorageEndpoint: kotlin.String? = null,
    @SerialName(value = "objectStorageRegion") val objectStorageRegion: kotlin.String? = null,
    @SerialName(value = "objectStoragePort") val objectStoragePort: kotlin.Int? = null,
    @SerialName(value = "objectStorageAccessKey") val objectStorageAccessKey: kotlin.String? = null,
    @SerialName(value = "objectStorageSecretKey") val objectStorageSecretKey: kotlin.String? = null,
    @SerialName(value = "objectStorageUseSSL") val objectStorageUseSSL: kotlin.Boolean? = null,
    @SerialName(value = "objectStorageUseProxy") val objectStorageUseProxy: kotlin.Boolean? = null,
    @SerialName(value = "objectStorageSetPublicRead") val objectStorageSetPublicRead: kotlin.Boolean? = null,
    @SerialName(value = "objectStorageS3ForcePathStyle") val objectStorageS3ForcePathStyle: kotlin.Boolean? = null,
    @SerialName(value = "enableIpLogging") val enableIpLogging: kotlin.Boolean? = null,
    @SerialName(value = "enableActiveEmailValidation") val enableActiveEmailValidation: kotlin.Boolean? = null,
    @SerialName(value = "enableChartsForRemoteUser") val enableChartsForRemoteUser: kotlin.Boolean? = null,
    @SerialName(value = "enableChartsForFederatedInstances") val enableChartsForFederatedInstances: kotlin.Boolean? = null,
    @SerialName(value = "enableServerMachineStats") val enableServerMachineStats: kotlin.Boolean? = null,
    @SerialName(value = "enableIdenticonGeneration") val enableIdenticonGeneration: kotlin.Boolean? = null,
    @SerialName(value = "serverRules") val serverRules: kotlin.collections.List<kotlin.String>? = null,
    @SerialName(value = "preservedUsernames") val preservedUsernames: kotlin.collections.List<kotlin.String>? = null,
) {
    /**
     * *
     * Values: None,All,Local,Remote
     */
    @Serializable
    enum class SensitiveMediaDetection(val value: kotlin.String) {
        @SerialName(value = "none")
        None("none"),

        @SerialName(value = "all")
        All("all"),

        @SerialName(value = "local")
        Local("local"),

        @SerialName(value = "remote")
        Remote("remote"),
    }

    /**
     * *
     * Values: Medium,Low,High,VeryLow,VeryHigh
     */
    @Serializable
    enum class SensitiveMediaDetectionSensitivity(val value: kotlin.String) {
        @SerialName(value = "medium")
        Medium("medium"),

        @SerialName(value = "low")
        Low("low"),

        @SerialName(value = "high")
        High("high"),

        @SerialName(value = "veryLow")
        VeryLow("veryLow"),

        @SerialName(value = "veryHigh")
        VeryHigh("veryHigh"),
    }
}
