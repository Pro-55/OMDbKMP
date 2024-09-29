package com.papslabs.omdb_kmp.util

expect object BuildConfig {
    val isDebug: Boolean
    val BaseUrl: String
    val ApiKey: String
}