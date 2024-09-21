package com.papslabs.omdb_kmp.data.repository

import com.papslabs.omdb_kmp.data.local.db.AppDatabase
import com.papslabs.omdb_kmp.data.local.db.model.EntityUser
import com.papslabs.omdb_kmp.data.local.db.model.parse
import com.papslabs.omdb_kmp.domain.model.DayPart
import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.model.User
import com.papslabs.omdb_kmp.domain.repository.MainRepository
import com.papslabs.omdb_kmp.domain.shared_preferences.SharedPreferences
import com.papslabs.omdb_kmp.util.Constants
import com.papslabs.omdb_kmp.util.extensions.getPartOfDay
import com.papslabs.omdb_kmp.util.wrappers.resourceFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDateTime

class MainRepositoryImpl(
    private val sp: SharedPreferences,
    private val db: AppDatabase
): MainRepository {

    // Global
    private val TAG = MainRepositoryImpl::class.simpleName

    override fun getSignUpStatus(): Flow<Resource<Boolean>> = resourceFlow {
        val hasSignedUp = sp.getBoolean(Constants.KEY_SIGN_UP_STATUS, false)
        emit(Resource.Success(data = hasSignedUp))
    }

    override fun signUp(
        id: String,
        firstName: String,
        lastName: String,
        email: String
    ): Flow<Resource<User>> = resourceFlow {
        val user = EntityUser(
            id = id,
            firstName = firstName,
            lastName = lastName,
            email = email
        )
        val insertResult = db.userDao
            .insert(user)

        if (insertResult > -1) {
            with(sp) {
                putBoolean(Constants.KEY_SIGN_UP_STATUS, true)
                putString(Constants.KEY_USER_ID, user.id)
            }
            emit(Resource.Success(user.parse()))
        } else {
            emit(Resource.Error(Constants.REQUEST_FAILED_MESSAGE))
        }
    }

    override fun getCurrentUser(): Flow<Resource<User>> = resourceFlow {
        val userId = sp.getString(Constants.KEY_USER_ID)
        if (userId.isNullOrEmpty()) {
            emit(Resource.Error("Invalid User ID!"))
            return@resourceFlow
        }

        val user = db.userDao.get(userId)
        if (user == null) {
            emit(Resource.Error("User Not Found!"))
            return@resourceFlow
        }

        emit(Resource.Success(user.parse()))
    }

    override suspend fun getGreeting(
        userName: String?,
        dateTime: LocalDateTime
    ): String {
        val greetingBuilder = StringBuilder("Good ")
        val part: String
        val emoji: String
        when (dateTime.getPartOfDay()) {
            DayPart.MORNING -> {
                part = "Morning"
                emoji = Constants.RISING_SUN_EMOJI
            }
            DayPart.AFTER_NOON -> {
                part = "Afternoon"
                emoji = Constants.SUN_EMOJI
            }
            DayPart.EVENING -> {
                part = "Evening"
                emoji = Constants.SETTING_SUN_EMOJI
            }
            DayPart.NIGHT -> {
                part = "Evening"
                emoji = Constants.CRESCENT_MOON_EMOJI
            }
        }
        return greetingBuilder.apply {
            append(part)
            if (!userName.isNullOrEmpty()) append(" $userName")
            append("! ")
            append(emoji)
        }
            .toString()
    }
}