package com.papslabs.omdb_kmp.domain.repository

import com.papslabs.omdb_kmp.domain.model.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun getSignUpStatus(): Flow<Resource<Boolean>>
}