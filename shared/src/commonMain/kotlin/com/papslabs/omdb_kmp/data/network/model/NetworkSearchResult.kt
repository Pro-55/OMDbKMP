package com.papslabs.omdb_kmp.data.network.model

import com.papslabs.omdb_kmp.data.local.db.model.EntityShortContent
import com.papslabs.omdb_kmp.data.local.db.model.parse
import com.papslabs.omdb_kmp.domain.model.SearchResult
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkSearchResult(
    @SerialName("Search") val search: List<NetworkShortContent?>? = null,
    @SerialName("totalResults") val totalResults: String? = null
)

fun NetworkSearchResult.parse(results: List<EntityShortContent>): SearchResult = SearchResult(
    search = results.parse(),
    total = totalResults?.toIntOrNull() ?: 0
)