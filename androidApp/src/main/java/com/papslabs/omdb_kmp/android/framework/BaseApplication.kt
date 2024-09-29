package com.papslabs.omdb_kmp.android.framework

import android.app.Application
import com.papslabs.omdb_kmp.android.di.viewModelModule
import com.papslabs.omdb_kmp.di.appDatabaseBuilderModule
import com.papslabs.omdb_kmp.di.appDatabaseModule
import com.papslabs.omdb_kmp.di.dataStoreModule
import com.papslabs.omdb_kmp.di.httpClientModule
import com.papslabs.omdb_kmp.di.mainRepositoryModule
import com.papslabs.omdb_kmp.di.oMDbKMPApiModule
import com.papslabs.omdb_kmp.di.sharedPreferencesModule
import com.papslabs.omdb_kmp.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BaseApplication)
            modules(
                dataStoreModule
                        + sharedPreferencesModule
                        + appDatabaseBuilderModule
                        + appDatabaseModule
                        + httpClientModule
                        + oMDbKMPApiModule
                        + mainRepositoryModule
                        + useCaseModule
                        + viewModelModule
            )
        }
    }
}