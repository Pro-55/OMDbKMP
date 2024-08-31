package com.papslabs.omdb_kmp.util.extensions

import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.util.Constants
import com.papslabs.omdb_kmp.util.DispatcherProvider
import com.papslabs.omdb_kmp.util.wrappers.NativeFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart

/**
 * converts regular flow into resource flow
 *
 * @return resource flow for given flow
 */
fun <T> Flow<Resource<T>>.asResourceFlow(): Flow<Resource<T>> =
    onStart { emit(Resource.Loading()) }
        .distinctUntilChanged()
        .catch {
            it.printStackTrace()
            when (it) {
                is IllegalArgumentException -> println("RF => TestLog: IllegalArgumentException")
                else -> println("RF => TestLog: Exception")
            }
            emit(Resource.Error(msg = Constants.MSG_SOMETHING_WENT_WRONG))
        }
        .flowOn(DispatcherProvider.IO)

/**
 * converts resource flow into native flow
 *
 * @return native flow for given resource flow
 */
fun <T> Flow<Resource<T>>.asNativeFlow(): NativeFlow<T> = NativeFlow(this)