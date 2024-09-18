package com.papslabs.omdb_kmp.android.ui.authentication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.papslabs.omdb_kmp.android.domain.state.SignUpScreenState
import com.papslabs.omdb_kmp.android.domain.state.TextFieldState
import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.use_case.SignUpUseCase
import com.papslabs.omdb_kmp.util.extensions.isValidEmail
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.UUID

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
): ViewModel() {

    // Global
    private val TAG = SignUpViewModel::class.java.simpleName
    var state by mutableStateOf(SignUpScreenState())
        private set
    var isLoading by mutableStateOf(false)
        private set
    var hasSignUpSuccessfully by mutableStateOf(false)
        private set
    var error by mutableStateOf<String?>(null)
        private set

    fun updateFirstName(firstName: String) {
        state = state.copy(
            firstName = TextFieldState(
                text = firstName.filter { it.isLetter() }
            )
        )
    }

    fun updateLastName(lastName: String) {
        state = state.copy(
            lastName = TextFieldState(
                text = lastName.filter { it.isLetter() }
            )
        )
    }

    fun updateEmail(email: String) {
        state = state.copy(
            email = TextFieldState(
                text = email.trim()
            )
        )
    }

    fun signUp() {
        if (isInvalid()) return
        signUpUseCase(
            id = UUID.randomUUID().toString(),
            firstName = state.firstName.text,
            lastName = state.lastName.text,
            email = state.email.text
        )
            .onEach {
                when (it) {
                    is Resource.Loading -> isLoading = true
                    is Resource.Success -> {
                        isLoading = false
                        hasSignUpSuccessfully = true
                    }
                    is Resource.Error -> {
                        error = it.msg
                        isLoading = false
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun isInvalid(): Boolean {
        val firstName = state.firstName.text.trim()
        val firstNameError = if (firstName.isEmpty()) "" else null

        val lastName = state.lastName.text.trim()
        val lastNameError = if (lastName.isEmpty()) "" else null

        val email = state.email.text.trim()
        val emailError = if (email.isEmpty() || !email.isValidEmail()) "" else null

        state = state.copy(
            firstName = state.firstName.copy(error = firstNameError),
            lastName = state.lastName.copy(error = lastNameError),
            email = state.email.copy(error = emailError)
        )
        return firstNameError != null
                || lastNameError != null
                || emailError != null
    }
}