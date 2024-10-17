package com.papslabs.omdb_kmp.util

import platform.Foundation.NSBundle

actual object BuildConfig {
    actual val isDebug: Boolean = try {
        NSBundle.mainBundle
            .infoDictionary
            ?.get("IS_DEBUG")
            ?.toString()
            ?.toBoolean()
                ?: false
    } catch (e: Exception) {
        false
    }

    actual val BaseUrl: String = NSBundle.mainBundle
        .infoDictionary
        ?.get("BASE_URL")
        ?.toString()
            ?: ""

    actual val ApiKey: String = NSBundle.mainBundle
        .infoDictionary
        ?.get("API_KEY")
        ?.toString()
            ?: ""
}