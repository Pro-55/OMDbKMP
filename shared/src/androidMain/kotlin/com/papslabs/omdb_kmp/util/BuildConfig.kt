package com.papslabs.omdb_kmp.util

import com.papslabs.omdb_kmp.BuildConfig as ProjectConfig

actual object BuildConfig {
    actual val isDebug: Boolean = ProjectConfig.DEBUG
    actual val BaseUrl: String = ProjectConfig.BaseUrl
    actual val ApiKey: String = ProjectConfig.ApiKey
}