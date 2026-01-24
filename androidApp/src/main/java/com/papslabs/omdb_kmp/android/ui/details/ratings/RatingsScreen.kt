package com.papslabs.omdb_kmp.android.ui.details.ratings

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun RatingsScreen(
    viewModel: RatingsViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    RatingsView(
        state = viewModel.state,
        onBack = onBack
    )
}