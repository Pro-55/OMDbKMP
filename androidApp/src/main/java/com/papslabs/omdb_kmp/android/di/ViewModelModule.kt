package com.papslabs.omdb_kmp.android.di

import com.papslabs.omdb_kmp.android.ui.authentication.SignUpViewModel
import com.papslabs.omdb_kmp.android.ui.router.RouterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::RouterViewModel)
    viewModelOf(::SignUpViewModel)
}