package com.papslabs.omdb_kmp.data.local.db

import androidx.room.Room
import androidx.room.RoomDatabase
import com.papslabs.omdb_kmp.util.Constants
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
fun getAppDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null
    )
    val dbFilePath = requireNotNull(documentDirectory).path + "/${Constants.OMDB_KMP_DB}"
    return Room.databaseBuilder<AppDatabase>(
        name = dbFilePath
    )
}