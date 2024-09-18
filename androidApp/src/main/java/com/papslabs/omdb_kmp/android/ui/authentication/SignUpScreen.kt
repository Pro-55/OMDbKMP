package com.papslabs.omdb_kmp.android.ui.authentication

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = koinViewModel(),
    navigateSignUpToHome: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    SignUpView(
        snackbarHostState = snackbarHostState,
        isLoading = viewModel.isLoading,
        state = viewModel.state,
        onFirstNameChange = viewModel::updateFirstName,
        onLastNameChange = viewModel::updateLastName,
        onEmailChange = viewModel::updateEmail,
        onSave = viewModel::signUp
    )
    LaunchedEffect(key1 = viewModel.hasSignUpSuccessfully) {
        if (!viewModel.hasSignUpSuccessfully) return@LaunchedEffect
        navigateSignUpToHome()
    }
    LaunchedEffect(key1 = viewModel.error) {
        val error = viewModel.error?.trim()
        if (error.isNullOrEmpty()) return@LaunchedEffect
        snackbarHostState.showSnackbar(message = error)
    }
}