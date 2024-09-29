package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.util.BuildConfig
import com.papslabs.omdb_kmp.util.httpEngine
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.dsl.module
import kotlinx.serialization.json.Json as KotlinXJson

val httpClientModule = module {
    single {
        HttpClient(httpEngine) {
            defaultRequest { url(BuildConfig.BaseUrl) }
            install(HttpTimeout) {
                connectTimeoutMillis = 1000
                requestTimeoutMillis = 5000
            }
            install(Logging) { level = if (BuildConfig.isDebug) LogLevel.BODY else LogLevel.NONE }
            install(ContentNegotiation) {
                json(KotlinXJson { ignoreUnknownKeys = true })
            }
        }
    }
}