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

import kotlinx.serialization.Required
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 *
 *
 * @param freedomOfSpeechNotReachFetchEnabled
 * @param graphqlIsTranslatableRwebTweetIsTranslatableEnabled
 * @param longformNotetweetsConsumptionEnabled
 * @param longformNotetweetsInlineMediaEnabled
 * @param longformNotetweetsRichTextReadEnabled
 * @param responsiveWebEditTweetApiEnabled
 * @param responsiveWebEnhanceCardsEnabled
 * @param responsiveWebGraphqlExcludeDirectiveEnabled
 * @param responsiveWebGraphqlSkipUserProfileImageExtensionsEnabled
 * @param responsiveWebGraphqlTimelineNavigationEnabled
 * @param responsiveWebMediaDownloadVideoEnabled
 * @param responsiveWebTwitterArticleTweetConsumptionEnabled
 * @param standardizedNudgesMisinfo
 * @param tweetAwardsWebTippingEnabled
 * @param tweetWithVisibilityResultsPreferGqlLimitedActionsPolicyEnabled
 * @param tweetypieUnmentionOptimizationEnabled
 * @param verifiedPhoneLabelEnabled
 * @param viewCountsEverywhereApiEnabled
 */
@Serializable
data class PostCreateTweetRequestFeatures(
    @Required
    @SerialName(value = "freedom_of_speech_not_reach_fetch_enabled")
    val freedomOfSpeechNotReachFetchEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "graphql_is_translatable_rweb_tweet_is_translatable_enabled")
    val graphqlIsTranslatableRwebTweetIsTranslatableEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "longform_notetweets_consumption_enabled")
    val longformNotetweetsConsumptionEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "longform_notetweets_inline_media_enabled")
    val longformNotetweetsInlineMediaEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "longform_notetweets_rich_text_read_enabled")
    val longformNotetweetsRichTextReadEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "responsive_web_edit_tweet_api_enabled")
    val responsiveWebEditTweetApiEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "responsive_web_enhance_cards_enabled")
    val responsiveWebEnhanceCardsEnabled: kotlin.Boolean = false,
    @Required
    @SerialName(value = "responsive_web_graphql_exclude_directive_enabled")
    val responsiveWebGraphqlExcludeDirectiveEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "responsive_web_graphql_skip_user_profile_image_extensions_enabled")
    val responsiveWebGraphqlSkipUserProfileImageExtensionsEnabled: kotlin.Boolean = false,
    @Required
    @SerialName(value = "responsive_web_graphql_timeline_navigation_enabled")
    val responsiveWebGraphqlTimelineNavigationEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "responsive_web_media_download_video_enabled")
    val responsiveWebMediaDownloadVideoEnabled: kotlin.Boolean = false,
    @Required
    @SerialName(value = "responsive_web_twitter_article_tweet_consumption_enabled")
    val responsiveWebTwitterArticleTweetConsumptionEnabled: kotlin.Boolean = false,
    @Required
    @SerialName(value = "standardized_nudges_misinfo")
    val standardizedNudgesMisinfo: kotlin.Boolean = true,
    @Required
    @SerialName(value = "tweet_awards_web_tipping_enabled")
    val tweetAwardsWebTippingEnabled: kotlin.Boolean = false,
    @Required
    @SerialName(value = "tweet_with_visibility_results_prefer_gql_limited_actions_policy_enabled")
    val tweetWithVisibilityResultsPreferGqlLimitedActionsPolicyEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "tweetypie_unmention_optimization_enabled")
    val tweetypieUnmentionOptimizationEnabled: kotlin.Boolean = true,
    @Required
    @SerialName(value = "verified_phone_label_enabled")
    val verifiedPhoneLabelEnabled: kotlin.Boolean = false,
    @Required
    @SerialName(value = "view_counts_everywhere_api_enabled")
    val viewCountsEverywhereApiEnabled: kotlin.Boolean = true,
)
