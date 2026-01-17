package com.papslabs.omdb_kmp.data.local.db.model

import androidx.room.Embedded
import androidx.room.Relation
import com.papslabs.omdb_kmp.domain.model.Content

data class ContentRelation(
    @Embedded
    val data: EntityContent?,

    @Relation(parentColumn = "id", entityColumn = "content_id", entity = EntityRating::class)
    val ratings: List<EntityRating>?
)

fun ContentRelation.parse(): Content? = data?.parse(ratings)