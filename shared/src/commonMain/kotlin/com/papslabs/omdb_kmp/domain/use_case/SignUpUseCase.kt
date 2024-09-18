package com.papslabs.omdb_kmp.domain.use_case

import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.model.User
import com.papslabs.omdb_kmp.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class SignUpUseCase(
    private val repository: MainRepository
) {
    operator fun invoke(
        id: String,
        firstName: String,
        lastName: String,
        email: String
    ): Flow<Resource<User>> = repository.signUp(
        id = id,
        firstName = firstName,
        lastName = lastName,
        email = email
    )
}