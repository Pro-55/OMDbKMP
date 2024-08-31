package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.domain.use_case.GetSignUpStatusUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val useCaseModule = module {
    factoryOf(::GetSignUpStatusUseCase)
}