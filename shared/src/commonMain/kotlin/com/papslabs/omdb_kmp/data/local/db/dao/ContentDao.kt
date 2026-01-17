package com.papslabs.omdb_kmp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.papslabs.omdb_kmp.data.local.db.model.ContentRelation
import com.papslabs.omdb_kmp.data.local.db.model.EntityContent

@Dao
interface ContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(content: EntityContent): Long

    @Query("SELECT * FROM content_table WHERE id=:id")
    suspend fun get(id: String): ContentRelation?

}