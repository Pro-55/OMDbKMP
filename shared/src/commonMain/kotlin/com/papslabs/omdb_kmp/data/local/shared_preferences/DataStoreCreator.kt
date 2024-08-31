package com.papslabs.omdb_kmp.data.local.shared_preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

fun createDataStore(
    getDataStorePath: () -> String
): DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(
    produceFile = { getDataStorePath().toPath() }
)