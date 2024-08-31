package com.papslabs.omdb_kmp.android.framework.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.papslabs.omdb_kmp.android.framework.navigation.Route
import com.papslabs.omdb_kmp.android.framework.navigation.Screen
import com.papslabs.omdb_kmp.android.ui.router.RouterScreen
import com.papslabs.omdb_kmp.android.util.extensions.navigateWithPopUpTo

fun NavGraphBuilder.routerNavGraph(navController: NavController) {
    navigation(
        route = Route.Router.name,
        startDestination = Screen.Router.route
    ) {
        composable(
            route = Screen.Router.route
        ) {
            RouterScreen(
                navigateRouterToSignUp = {
                    navController.navigateWithPopUpTo(
                        route = Route.Auth.name,
                        popUpTo = Route.Router.name
                    )
                },
                navigateRouterToHome = {
                    navController.navigateWithPopUpTo(
                        route = Route.App.name,
                        popUpTo = Route.Router.name
                    )
                }
            )
        }
    }
}