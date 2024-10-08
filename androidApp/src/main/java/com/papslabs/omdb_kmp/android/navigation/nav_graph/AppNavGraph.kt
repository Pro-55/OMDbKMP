package com.papslabs.omdb_kmp.android.framework.navigation.nav_graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.papslabs.omdb_kmp.android.framework.navigation.Route
import com.papslabs.omdb_kmp.android.framework.navigation.Screen

fun NavGraphBuilder.appNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Home.route,
        route = Route.App.name
    ) {
        composable(route = Screen.Home.route) {
            // TODO: ADD APP SCREENS
            Text(
                modifier = Modifier
                    .fillMaxSize(),
                text = "Home!",
            )
        }
    }
}