package com.papslabs.omdb_kmp.android.framework.navigation.nav_graph

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.papslabs.omdb_kmp.android.framework.navigation.Route
import com.papslabs.omdb_kmp.android.framework.navigation.Screen
import com.papslabs.omdb_kmp.android.util.extensions.navigateWithPopUpTo

fun NavGraphBuilder.routerNavGraph(navController: NavController) {
    navigation(
        startDestination = Screen.Router.route,
        route = Route.Router.name
    ) {
        composable(route = Screen.Router.route) {
            // TODO: ADD SHARED PREF LOGIC
            val key by remember { mutableStateOf(false) }
            LaunchedEffect(key) {
                navController.navigateWithPopUpTo(
                    route = Route.Auth.name,
                    popUpTo = Route.Router.name
                )
            }
        }
    }
}