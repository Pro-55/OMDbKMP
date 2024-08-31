package com.papslabs.omdb_kmp.android.ui.router

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.use_case.GetSignUpStatusUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RouterViewModel(
    private val getSignUpStatusUseCase: GetSignUpStatusUseCase
): ViewModel() {

    // Global
    private val TAG = RouterViewModel::class.java.simpleName
    var signUpStatus by mutableStateOf<Boolean?>(null)
        private set
    var error by mutableStateOf<String?>(null)
        private set

    init {
        getLoginStatus()
    }

    private fun getLoginStatus() {
        getSignUpStatusUseCase()
            .onEach {
                when (it) {
                    is Resource.Loading -> Unit
                    is Resource.Success -> signUpStatus = it.data
                    is Resource.Error -> error = it.msg
                }
            }
            .launchIn(viewModelScope)
    }
}