package com.papslabs.omdb_kmp.util

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual val httpEngine: HttpClientEngine = Darwin.create()