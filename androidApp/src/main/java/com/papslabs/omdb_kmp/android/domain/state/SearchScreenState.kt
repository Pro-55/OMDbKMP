package com.papslabs.omdb_kmp.android.domain.state

import com.papslabs.omdb_kmp.domain.model.SearchResult
import com.papslabs.omdb_kmp.domain.model.ShortContent
import com.papslabs.omdb_kmp.domain.model.Type

data class SearchScreenState(
    val category: Type = Type.MOVIE,
    val result: SearchResult = SearchResult(),
    val query: String = "",
    val peekContent: ShortContent? = null,
    val shouldPeek: Boolean = false
)