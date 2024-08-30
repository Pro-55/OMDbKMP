package com.papslabs.omdb_kmp.android.framework.navigation.nav_graph

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.papslabs.omdb_kmp.android.framework.navigation.Route
import com.papslabs.omdb_kmp.android.framework.navigation.Screen
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
            // TODO: ADD AUTH SCREEN
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Auth!")
                Spacer(modifier = Modifier.height(height = 8.dp))
                Button(
                    onClick = {
                        navController.navigateWithPopUpTo(
                            route = Route.App.name,
                            popUpTo = Route.Auth.name
                        )
                    }
                ) {
                    Text(text = "Sign Up")
                }
            }
        }
    }
}