package com.papslabs.omdb_kmp.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkSearchResult(
    @SerialName("Search") val search: List<NetworkShortContent?>? = null,
    @SerialName("totalResults") val totalResults: String? = null
)