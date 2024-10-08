package com.papslabs.omdb_kmp.data.model

sealed class Resource<T>(val msg: String? = null, val data: T? = null) {
    class Loading<T> : Resource<T>()
    class Success<T>(data: T?) : Resource<T>(data = data)
    class Error<T>(msg: String?) : Resource<T>(msg = msg)
}