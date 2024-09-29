package com.papslabs.omdb_kmp.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkShortContent(
    @SerialName("imdbID") val id: String,
    @SerialName("Title") val title: String,
    @SerialName("Year") val year: String,
    @SerialName("Poster") val poster: String? = null
)