package com.papslabs.omdb_kmp.data.local.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.papslabs.omdb_kmp.domain.model.ShortContent
import com.papslabs.omdb_kmp.domain.model.Type
import com.papslabs.omdb_kmp.util.Constants

@Entity(tableName = "short_content_table")
data class EntityShortContent(
    @PrimaryKey(autoGenerate = false)
    val id: String,

    val type: Type,

    val poster: String?,

    val title: String,

    val year: String?,
)

fun EntityShortContent.parse(): ShortContent = ShortContent(
    id = id,
    title = title,
    year = year ?: Constants.NOT_AVAILABLE,
    poster = poster
)

fun List<EntityShortContent?>.parse(): List<ShortContent> = mapNotNull { it?.parse() }