package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.data.local.shared_preferences.getDataStore
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val dataStoreModule = module {
    singleOf(::getDataStore)
}