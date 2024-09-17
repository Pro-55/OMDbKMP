package com.papslabs.omdb_kmp.data.local.db

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver

fun getAppDatabase(
    builder: RoomDatabase.Builder<AppDatabase>
): AppDatabase = builder
    .setDriver(BundledSQLiteDriver())
    .fallbackToDestructiveMigrationOnDowngrade(dropAllTables = true)
    .build()