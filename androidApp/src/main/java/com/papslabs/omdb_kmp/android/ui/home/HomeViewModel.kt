package com.papslabs.omdb_kmp.android.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.papslabs.omdb_kmp.android.domain.state.HomeScreenState
import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.use_case.GetCurrentUserUseCase
import com.papslabs.omdb_kmp.domain.use_case.GetGreetingUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getCurrentUserUseCase: GetCurrentUserUseCase,
    private val getGreetingUseCase: GetGreetingUseCase
): ViewModel() {

    // Global
    private val TAG = HomeViewModel::class.java.simpleName
    var state by mutableStateOf(HomeScreenState())
        private set

    init {
        getCurrentUser()
    }

    private fun getCurrentUser() {
        getCurrentUserUseCase()
            .onEach {
                when (it) {
                    is Resource.Loading -> Unit
                    is Resource.Success -> {
                        state = state.copy(user = it.data)
                        getGreeting()
                    }
                    is Resource.Error -> {
                        state = state.copy(user = null)
                        getGreeting()
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun getGreeting() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                while (true) {
                    val greeting = runCatching {
                        getGreetingUseCase(userName = state.user?.firstName)
                    }
                        .getOrNull()
                    if (!greeting.isNullOrEmpty()) {
                        withContext(Dispatchers.Main) {
                            state = state.copy(greeting = greeting)
                        }
                    }
                    delay(30000L)
                }
            }
        }
    }
}