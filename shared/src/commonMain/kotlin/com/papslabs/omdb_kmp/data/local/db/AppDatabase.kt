package com.papslabs.omdb_kmp.data.local.db

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.papslabs.omdb_kmp.data.local.db.dao.ShortContentDao
import com.papslabs.omdb_kmp.data.local.db.dao.UserDao
import com.papslabs.omdb_kmp.data.local.db.model.EntityShortContent
import com.papslabs.omdb_kmp.data.local.db.model.EntityUser
import com.papslabs.omdb_kmp.util.RoomTypeConverter

@Database(
    entities = [
        EntityUser::class,
        EntityShortContent::class
    ],
    version = 1
)
@TypeConverters(RoomTypeConverter::class)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase: RoomDatabase() {

    abstract val userDao: UserDao
    abstract val shortContentDao: ShortContentDao

}