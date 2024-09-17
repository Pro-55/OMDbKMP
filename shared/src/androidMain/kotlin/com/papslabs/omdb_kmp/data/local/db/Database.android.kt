package com.papslabs.omdb_kmp.data.local.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.papslabs.omdb_kmp.util.Constants

fun getAppDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(Constants.OMDB_KMP_DB)
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}