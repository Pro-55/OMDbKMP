package com.papslabs.omdb_kmp.android.ui.home

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    navigateHomeToSearchMovies: () -> Unit,
    navigateHomeToSearchSeries: () -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    HomeView(
        snackbarHostState = snackbarHostState,
        state = viewModel.state,
        onMovieSelected = navigateHomeToSearchMovies,
        onSeriesSelected = navigateHomeToSearchSeries
    )
}