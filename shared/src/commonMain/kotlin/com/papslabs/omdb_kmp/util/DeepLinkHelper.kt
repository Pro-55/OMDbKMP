package com.papslabs.omdb_kmp.util

object DeepLinkHelper {
    private const val DEEP_LINK_HOST = "https://omdb.papslabs.com"

    fun getDetailsDeepLink(
        contentId: String? = null
    ): String = StringBuilder(DEEP_LINK_HOST)
        .append("/")
        .append("details")
        .append("?")
        .append("contentId=")
        .append(contentId ?: "{contentId}")
        .toString()
}