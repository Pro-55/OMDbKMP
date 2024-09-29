package com.papslabs.omdb_kmp.util

import com.papslabs.omdb_kmp.BuildConfig as ProjectConfig

actual object BuildConfig {
    actual val isDebug: Boolean
        get() = ProjectConfig.DEBUG

    actual val BaseUrl: String
        get() = ProjectConfig.BaseUrl

    actual val ApiKey: String
        get() = ProjectConfig.ApiKey
}