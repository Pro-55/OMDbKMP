package com.papslabs.omdb_kmp.android.util.extensions

import kotlinx.serialization.json.Json

inline fun <reified T> String.toObject(): T? = Json.decodeFromString<T?>(this)

inline fun <reified T> String.toObjectList(): List<T>? = Json.decodeFromString<List<T>?>(this)