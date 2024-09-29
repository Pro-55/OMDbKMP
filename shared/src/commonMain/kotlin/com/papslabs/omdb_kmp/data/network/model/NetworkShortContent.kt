package com.papslabs.omdb_kmp.data.network.model

import com.papslabs.omdb_kmp.data.local.db.model.EntityShortContent
import com.papslabs.omdb_kmp.domain.model.Type
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkShortContent(
    @SerialName("imdbID") val id: String,
    @SerialName("Title") val title: String,
    @SerialName("Year") val year: String,
    @SerialName("Poster") val poster: String? = null
)

fun NetworkShortContent.parse(type: Type): EntityShortContent = EntityShortContent(
    id = id,
    type = type,
    poster = poster,
    title = title,
    year = year
)

fun List<NetworkShortContent?>.parse(
    type: Type
): List<EntityShortContent> = mapNotNull { it?.parse(type) }