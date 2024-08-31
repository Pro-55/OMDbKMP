package com.papslabs.omdb_kmp.domain.shared_preferences

interface SharedPreferences {
    suspend fun putString(key: String, value: String?)
    suspend fun getString(
        key: String,
        defaultValue: String? = null
    ): String?

    suspend fun putInt(key: String, value: Int?)
    suspend fun getInt(
        key: String,
        defaultValue: Int? = null
    ): Int?

    suspend fun putLong(key: String, value: Long?)
    suspend fun getLong(
        key: String,
        defaultValue: Long? = null
    ): Long?

    suspend fun putFloat(key: String, value: Float?)
    suspend fun getFloat(
        key: String,
        defaultValue: Float? = null
    ): Float?

    suspend fun putBoolean(key: String, value: Boolean?)
    suspend fun getBoolean(
        key: String,
        defaultValue: Boolean? = null
    ): Boolean?

    suspend fun clear()
}