package com.papslabs.omdb_kmp.domain.use_case

import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.model.User
import com.papslabs.omdb_kmp.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class GetCurrentUserUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(): Flow<Resource<User>> = repository.getCurrentUser()
}