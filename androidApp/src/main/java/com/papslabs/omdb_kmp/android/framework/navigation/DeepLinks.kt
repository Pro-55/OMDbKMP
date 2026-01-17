package com.papslabs.omdb_kmp.android.framework.navigation

import android.content.Intent
import androidx.navigation.NavDeepLink
import androidx.navigation.navDeepLink
import com.papslabs.omdb_kmp.util.DeepLinkHelper.getDetailsDeepLink

object DeepLinks {

    val list: List<NavDeepLink> = listOf(
        navDeepLink {
            action = Intent.ACTION_VIEW
            uriPattern = getDetailsDeepLink()
        }
    )
}