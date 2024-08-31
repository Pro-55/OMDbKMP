package com.papslabs.omdb_kmp.android.ui.router

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import org.koin.androidx.compose.koinViewModel

@Composable
fun RouterScreen(
    viewModel: RouterViewModel = koinViewModel(),
    navigateRouterToSignUp: () -> Unit,
    navigateRouterToHome: () -> Unit
) {
    LaunchedEffect(key1 = viewModel.signUpStatus) {
        when (viewModel.signUpStatus) {
            false -> navigateRouterToSignUp()
            true -> navigateRouterToHome()
            else -> Unit
        }
    }

    val context = LocalContext.current
    LaunchedEffect(key1 = viewModel.error) {
        val error = viewModel.error?.trim()
        if (error.isNullOrEmpty()) return@LaunchedEffect
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        (context as? Activity)?.finish()
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
}