package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.data.local.db.getAppDatabaseBuilder
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val appDatabaseBuilderModule = module {
    singleOf(::getAppDatabaseBuilder)
}