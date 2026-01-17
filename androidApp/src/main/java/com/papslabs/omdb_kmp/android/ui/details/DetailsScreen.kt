package com.papslabs.omdb_kmp.android.ui.details

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.papslabs.omdb_kmp.domain.model.Rating
import com.papslabs.omdb_kmp.domain.model.TeamDetails
import com.papslabs.omdb_kmp.util.Constants
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = koinViewModel(),
    onBack: () -> Unit,
    navigateDetailsToFullPoster: (String?) -> Unit,
    navigateDetailsToRatings: (List<Rating>) -> Unit,
    navigateDetailsToTeamDetails: (TeamDetails) -> Unit,
    navigateDetailsToEpisodes: (String, Int) -> Unit
) {
    val context = LocalContext.current
    DetailsView(
        state = viewModel.state,
        onBack = onBack,
        onShare = viewModel::share,
        onPosterClicked = navigateDetailsToFullPoster,
        onRatingsClicked = navigateDetailsToRatings,
        onTeamClicked = navigateDetailsToTeamDetails,
        onSeasonSelected = navigateDetailsToEpisodes
    )
    LaunchedEffect(key1 = viewModel.error) {
        val error = viewModel.error?.trim()
        if (error.isNullOrEmpty()) return@LaunchedEffect
        Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
        if (Constants.ERROR_MESSAGE_INVALID_REQUEST == error) {
            onBack()
        }
    }
}