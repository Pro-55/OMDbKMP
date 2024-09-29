package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.data.network.api.contract.OMDbKMPApi
import com.papslabs.omdb_kmp.data.network.api.impl.OMDbKMPApiImpl
import org.koin.dsl.module

val oMDbKMPApiModule = module {
    single<OMDbKMPApi> { OMDbKMPApiImpl(get()) }
}