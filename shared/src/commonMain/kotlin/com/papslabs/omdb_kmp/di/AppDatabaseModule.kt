package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.data.local.db.getAppDatabase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appDatabaseModule = module {
    singleOf(::getAppDatabase)
}