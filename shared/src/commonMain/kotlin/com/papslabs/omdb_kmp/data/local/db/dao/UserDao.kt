package com.papslabs.omdb_kmp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.papslabs.omdb_kmp.data.local.db.model.EntityUser

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: EntityUser): Long

    @Query("SELECT * FROM user_table WHERE id=:id")
    suspend fun get(id: String): EntityUser?

}