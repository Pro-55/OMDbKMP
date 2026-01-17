package com.papslabs.omdb_kmp.domain.use_case

import com.papslabs.omdb_kmp.domain.model.Content
import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetDetailsUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(
        id: String,
        plot: String
    ): Flow<Resource<Content>> = repository.getDetails(
        id = id,
        plot = plot
    )
}