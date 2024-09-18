package com.papslabs.omdb_kmp.android.framework.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.papslabs.omdb_kmp.android.framework.navigation.Route
import com.papslabs.omdb_kmp.android.framework.navigation.Screen
import com.papslabs.omdb_kmp.android.ui.authentication.SignUpScreen
import com.papslabs.omdb_kmp.android.util.extensions.navigateWithPopUpTo

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        route = Route.Auth.name,
        startDestination = Screen.SignUp.route
    ) {
        composable(
            route = Screen.SignUp.route,
            arguments = Screen.SignUp.arguments
        ) {
            SignUpScreen(
                navigateSignUpToHome = {
                    navController.navigateWithPopUpTo(
                        route = Route.App.name,
                        popUpTo = Route.Auth.name
                    )
                }
            )
        }
    }
}