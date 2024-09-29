package com.papslabs.omdb_kmp.domain.use_case

import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.model.SearchResult
import com.papslabs.omdb_kmp.domain.model.Type
import com.papslabs.omdb_kmp.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class SearchContentUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(
        query: String,
        page: Int,
        type: Type
    ): Flow<Resource<SearchResult>> = repository.searchContent(
        query = query,
        page = page,
        type = type
    )
}