package com.papslabs.omdb_kmp.android.framework.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.papslabs.omdb_kmp.android.framework.navigation.Route
import com.papslabs.omdb_kmp.android.framework.navigation.Screen
import com.papslabs.omdb_kmp.android.ui.home.HomeScreen
import com.papslabs.omdb_kmp.android.ui.search.SearchScreen
import com.papslabs.omdb_kmp.domain.model.Type

fun NavGraphBuilder.appNavGraph(
    navController: NavController,
    onBack: () -> Unit
) {
    navigation(
        route = Route.App.name,
        startDestination = Screen.Home.route
    ) {
        composable(
            route = Screen.Home.route,
            arguments = Screen.Home.arguments
        ) {
            HomeScreen(
                navigateHomeToSearchMovies = {
                    navController.navigate(
                        route = Screen.Search.getPath(category = Type.MOVIE)
                    )
                },
                navigateHomeToSearchSeries = {
                    navController.navigate(
                        route = Screen.Search.getPath(category = Type.SERIES)
                    )
                }
            )
        }
        composable(
            route = Screen.Search.getPath(),
            arguments = Screen.Search.arguments
        ) {
            SearchScreen(
                navigateSearchToDetails = {}
            )
        }
    }
}