package com.papslabs.omdb_kmp.domain.repository

import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDateTime

interface MainRepository {
    fun getSignUpStatus(): Flow<Resource<Boolean>>

    fun signUp(
        id: String,
        firstName: String,
        lastName: String,
        email: String
    ): Flow<Resource<User>>

    fun getCurrentUser(): Flow<Resource<User>>

    suspend fun getGreeting(
        userName: String?,
        dateTime: LocalDateTime
    ): String
}