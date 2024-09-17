package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.domain.use_case.GetSignUpStatusUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun init() {
    startKoin {
        modules(
            dataStoreModule
                    + sharedPreferencesModule
                    + appDatabaseBuilderModule
                    + appDatabaseModule
                    + mainRepositoryModule
                    + useCaseModule
        )
    }
}

class UseCaseHelper: KoinComponent {
    private val _getSignUpStatusUseCase: GetSignUpStatusUseCase by inject()
    val getSignUpStatusUseCase: GetSignUpStatusUseCase
        get() = _getSignUpStatusUseCase
}