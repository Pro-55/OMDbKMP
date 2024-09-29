package com.papslabs.omdb_kmp.util

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual val httpEngine: HttpClientEngine = OkHttp.create()