package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.data.local.shared_preferences.SharedPreferencesImpl
import com.papslabs.omdb_kmp.domain.shared_preferences.SharedPreferences
import org.koin.dsl.module

val sharedPreferencesModule = module {
    single<SharedPreferences> { SharedPreferencesImpl(get()) }
}