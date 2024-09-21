package com.papslabs.omdb_kmp.data.local.shared_preferences

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.papslabs.omdb_kmp.domain.shared_preferences.SharedPreferences
import kotlinx.coroutines.flow.first

class SharedPreferencesImpl(
    private val dataStore: DataStore<Preferences>
): SharedPreferences {

    override suspend fun putString(
        key: String,
        value: String?
    ) {
        dataStore.edit {
            val stringPreferencesKey = stringPreferencesKey(key)
            if (value == null) {
                it.remove(stringPreferencesKey)
            } else {
                it[stringPreferencesKey] = value
            }
        }
    }

    override suspend fun getString(
        key: String,
        defaultValue: String?
    ): String? {
        val stringPreferencesKey = stringPreferencesKey(key)
        return dataStore.data
            .first()[stringPreferencesKey]
                ?: defaultValue
    }

    override suspend fun putInt(
        key: String,
        value: Int?
    ) {
        dataStore.edit {
            val intPreferencesKey = intPreferencesKey(key)
            if (value == null) {
                it.remove(intPreferencesKey)
            } else {
                it[intPreferencesKey] = value
            }
        }
    }

    override suspend fun getInt(
        key: String,
        defaultValue: Int?
    ): Int? {
        val intPreferencesKey = intPreferencesKey(key)
        return dataStore.data
            .first()[intPreferencesKey]
                ?: defaultValue
    }

    override suspend fun putLong(
        key: String,
        value: Long?
    ) {
        dataStore.edit {
            val longPreferencesKey = longPreferencesKey(key)
            if (value == null) {
                it.remove(longPreferencesKey)
            } else {
                it[longPreferencesKey] = value
            }
        }
    }

    override suspend fun getLong(
        key: String,
        defaultValue: Long?
    ): Long? {
        val longPreferencesKey = longPreferencesKey(key)
        return dataStore.data
            .first()[longPreferencesKey]
                ?: defaultValue
    }

    override suspend fun putFloat(
        key: String,
        value: Float?
    ) {
        dataStore.edit {
            val floatPreferencesKey = floatPreferencesKey(key)
            if (value == null) {
                it.remove(floatPreferencesKey)
            } else {
                it[floatPreferencesKey] = value
            }
        }
    }

    override suspend fun getFloat(
        key: String,
        defaultValue: Float?
    ): Float? {
        val floatPreferencesKey = floatPreferencesKey(key)
        return dataStore.data
            .first()[floatPreferencesKey]
                ?: defaultValue
    }

    override suspend fun putBoolean(
        key: String,
        value: Boolean?
    ) {
        dataStore.edit {
            val booleanPreferencesKey = booleanPreferencesKey(key)
            if (value == null) {
                it.remove(booleanPreferencesKey)
            } else {
                it[booleanPreferencesKey] = value
            }
        }
    }

    override suspend fun getBoolean(
        key: String,
        defaultValue: Boolean?
    ): Boolean? {
        val booleanPreferencesKey = booleanPreferencesKey(key)
        return dataStore.data
            .first()[booleanPreferencesKey]
                ?: defaultValue
    }

    override suspend fun clear() {
        dataStore.edit { it.clear() }
    }
}