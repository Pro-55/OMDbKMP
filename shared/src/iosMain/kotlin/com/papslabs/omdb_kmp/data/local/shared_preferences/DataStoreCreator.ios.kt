package com.papslabs.omdb_kmp.data.local.shared_preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.papslabs.omdb_kmp.util.Constants
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
fun getDataStore(): DataStore<Preferences> = createDataStore {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null
    )
    requireNotNull(documentDirectory).path + "/${Constants.OMDB_KMP_SHARED_PREFS}"
}