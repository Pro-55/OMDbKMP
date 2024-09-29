package com.papslabs.omdb_kmp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.papslabs.omdb_kmp.data.local.db.model.EntityShortContent
import com.papslabs.omdb_kmp.domain.model.Type

@Dao
interface ShortContentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(contents: List<EntityShortContent>): List<Long>

    @Query("SELECT * FROM short_content_table WHERE type=:type AND title LIKE :searchString")
    suspend fun searchForType(type: Type, searchString: String): List<EntityShortContent?>?

}