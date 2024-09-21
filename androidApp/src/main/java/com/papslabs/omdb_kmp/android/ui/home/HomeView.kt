package com.papslabs.omdb_kmp.android.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.papslabs.omdb_kmp.android.R
import com.papslabs.omdb_kmp.android.domain.state.HomeScreenState
import com.papslabs.omdb_kmp.android.theme.OMDbKmpTheme
import com.papslabs.omdb_kmp.android.util.PhoneLightPreview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(
    snackbarHostState: SnackbarHostState,
    state: HomeScreenState,
    onMovieSelected: () -> Unit,
    onSeriesSelected: () -> Unit
) {
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = state.greeting,
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            Spacer(
                modifier = Modifier
                    .height(height = 16.dp)
            )
            ContentTypeCard(
                modifier = Modifier
                    .weight(weight = 1.0F),
                icon = painterResource(id = R.drawable.ic_movies),
                label = stringResource(id = R.string.label_movies),
                contentDescription = stringResource(id = R.string.cd_movies),
                onClick = onMovieSelected
            )
            Spacer(
                modifier = Modifier
                    .height(height = 16.dp)
            )
            ContentTypeCard(
                modifier = Modifier
                    .weight(weight = 1.0F),
                icon = painterResource(id = R.drawable.ic_series),
                label = stringResource(id = R.string.label_series),
                contentDescription = stringResource(id = R.string.cd_series),
                onClick = onSeriesSelected
            )
        }
    }
}

@PhoneLightPreview
@Composable
fun HomeViewPreview() {
    OMDbKmpTheme {
        val snackbarHostState = remember { SnackbarHostState() }
        HomeView(
            snackbarHostState = snackbarHostState,
            state = HomeScreenState(
                greeting = "Hello there!"
            ),
            onMovieSelected = {},
            onSeriesSelected = {}
        )
    }
}