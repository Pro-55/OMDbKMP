package com.papslabs.omdb_kmp.android.ui.search

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.papslabs.omdb_kmp.domain.model.ShortContent
import org.koin.androidx.compose.koinViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = koinViewModel(),
    navigateSearchToDetails: (ShortContent) -> Unit
) {
    val context = LocalContext.current
    SearchView(
        isLoading = viewModel.isLoading,
        state = viewModel.state,
        onSearchQueryUpdated = viewModel::onSearchQueryUpdated,
        onClearSearchQuery = viewModel::onClearSearchQuery,
        onSearch = viewModel::searchNow,
        onLoadMore = viewModel::loadMore,
        onHold = viewModel::onHold,
        onRelease = viewModel::onRelease,
        onContentClicked = navigateSearchToDetails
    )
    LaunchedEffect(key1 = viewModel.error) {
        val error = viewModel.error?.trim()
        if (error.isNullOrEmpty()) return@LaunchedEffect
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        viewModel.resetError()
    }
}