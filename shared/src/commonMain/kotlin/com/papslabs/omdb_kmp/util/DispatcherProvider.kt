package com.papslabs.omdb_kmp.util

import kotlinx.coroutines.CoroutineDispatcher

expect object DispatcherProvider {
    val Default: CoroutineDispatcher
    val Main: CoroutineDispatcher
    val Unconfined: CoroutineDispatcher
    val IO: CoroutineDispatcher
}