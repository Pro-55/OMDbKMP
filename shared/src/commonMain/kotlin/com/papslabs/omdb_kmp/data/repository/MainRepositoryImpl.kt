package com.papslabs.omdb_kmp.data.repository

import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.repository.MainRepository
import com.papslabs.omdb_kmp.domain.shared_preferences.SharedPreferences
import com.papslabs.omdb_kmp.util.Constants
import com.papslabs.omdb_kmp.util.wrappers.resourceFlow
import kotlinx.coroutines.flow.Flow

class MainRepositoryImpl(
    private val sp: SharedPreferences
): MainRepository {

    // Global
    private val TAG = MainRepositoryImpl::class.simpleName

    override fun getSignUpStatus(): Flow<Resource<Boolean>> = resourceFlow {
        val hasSignedUp = sp.getBoolean(Constants.KEY_SIGN_UP_STATUS, false)
        emit(Resource.Success(data = hasSignedUp))
    }

}