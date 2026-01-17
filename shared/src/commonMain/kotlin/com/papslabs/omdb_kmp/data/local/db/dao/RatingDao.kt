package com.papslabs.omdb_kmp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.papslabs.omdb_kmp.data.local.db.model.EntityRating

@Dao
interface RatingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(ratings: List<EntityRating>): List<Long>

}