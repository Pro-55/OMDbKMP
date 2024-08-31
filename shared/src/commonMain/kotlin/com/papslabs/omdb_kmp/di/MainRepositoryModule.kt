package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.data.repository.MainRepositoryImpl
import com.papslabs.omdb_kmp.domain.repository.MainRepository
import org.koin.dsl.module

val mainRepositoryModule = module {
    single<MainRepository> { MainRepositoryImpl(get()) }
}