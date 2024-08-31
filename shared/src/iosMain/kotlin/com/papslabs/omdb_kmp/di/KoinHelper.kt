package com.papslabs.omdb_kmp.di

import org.koin.core.context.startKoin

fun init() {
    startKoin {
        modules(
            dataStoreModule
                    + sharedPreferencesModule
                    + mainRepositoryModule
        )
    }
}