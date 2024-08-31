package com.papslabs.omdb_kmp.data.local.shared_preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.papslabs.omdb_kmp.util.Constants

fun getDataStore(
    context: Context
): DataStore<Preferences> = createDataStore {
    context.filesDir
        .resolve(Constants.OMDB_KMP_SHARED_PREFS)
        .absolutePath
}