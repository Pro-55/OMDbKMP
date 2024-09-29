package com.papslabs.omdb_kmp.util

import platform.Foundation.NSBundle

actual object BuildConfig {
    actual val isDebug: Boolean
        get() = try {
            NSBundle.mainBundle
                .infoDictionary
                ?.get("IS_DEBUG")
                ?.toString()
                ?.toBoolean()
                    ?: false
        } catch (e: Exception) {
            false
        }

    actual val BaseUrl: String
        get() = NSBundle.mainBundle
            .infoDictionary
            ?.get("BASE_URL")
            ?.toString()
                ?: ""

    actual val ApiKey: String
        get() = NSBundle.mainBundle
            .infoDictionary
            ?.get("API_KEY")
            ?.toString()
                ?: ""
}