package com.papslabs.omdb_kmp.android.framework

import android.app.Application
import com.papslabs.omdb_kmp.di.dataStoreModule
import com.papslabs.omdb_kmp.di.mainRepositoryModule
import com.papslabs.omdb_kmp.di.sharedPreferencesModule
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
                        + mainRepositoryModule
            )
        }
    }
}