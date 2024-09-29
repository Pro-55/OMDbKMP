package com.papslabs.omdb_kmp.di

import com.papslabs.omdb_kmp.domain.use_case.GetCurrentUserUseCase
import com.papslabs.omdb_kmp.domain.use_case.GetGreetingUseCase
import com.papslabs.omdb_kmp.domain.use_case.GetSignUpStatusUseCase
import com.papslabs.omdb_kmp.domain.use_case.SearchContentUseCase
import com.papslabs.omdb_kmp.domain.use_case.SignUpUseCase
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
                    + httpClientModule
                    + oMDbKMPApiModule
                    + mainRepositoryModule
                    + useCaseModule
        )
    }
}

class UseCaseHelper: KoinComponent {
    private val _getSignUpStatusUseCase: GetSignUpStatusUseCase by inject()
    val getSignUpStatusUseCase: GetSignUpStatusUseCase
        get() = _getSignUpStatusUseCase

    private val _signUpUseCase: SignUpUseCase by inject()
    val signUpUseCase: SignUpUseCase
        get() = _signUpUseCase

    private val _getCurrentUserUseCase: GetCurrentUserUseCase by inject()
    val getCurrentUserUseCase: GetCurrentUserUseCase
        get() = _getCurrentUserUseCase

    private val _getGreetingUseCase: GetGreetingUseCase by inject()
    val getGreetingUseCase: GetGreetingUseCase
        get() = _getGreetingUseCase

    private val _searchContentUseCase: SearchContentUseCase by inject()
    val searchContentUseCase: SearchContentUseCase
        get() = _searchContentUseCase
}