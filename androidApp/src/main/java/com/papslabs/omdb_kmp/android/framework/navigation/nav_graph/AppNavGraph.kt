package com.papslabs.omdb_kmp.android.framework.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.papslabs.omdb_kmp.android.framework.navigation.Route
import com.papslabs.omdb_kmp.android.framework.navigation.Screen
import com.papslabs.omdb_kmp.android.ui.home.HomeScreen

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
                navigateHomeToSearchMovies = {},
                navigateHomeToSearchSeries = {}
            )
        }
    }
}