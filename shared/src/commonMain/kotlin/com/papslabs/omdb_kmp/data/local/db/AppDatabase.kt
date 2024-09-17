package com.papslabs.omdb_kmp.data.local.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.papslabs.omdb_kmp.data.local.db.dao.UserDao
import com.papslabs.omdb_kmp.data.local.db.model.EntityUser

@Database(
    entities = [
        EntityUser::class
    ],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {

    abstract val userDao: UserDao

}