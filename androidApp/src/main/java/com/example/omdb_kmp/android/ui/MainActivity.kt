package com.example.omdb_kmp.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.omdb_kmp.android.framework.navigation.Route
import com.example.omdb_kmp.android.framework.navigation.nav_graph.appNavGraph
import com.example.omdb_kmp.android.framework.navigation.nav_graph.authNavGraph
import com.example.omdb_kmp.android.framework.navigation.nav_graph.routerNavGraph
import com.example.omdb_kmp.android.theme.OMDbKmpTheme

class MainActivity : ComponentActivity() {

    // Global
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            OMDbKmpTheme {
                Surface {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .safeDrawingPadding()
                    ) {
                        val navController = rememberNavController()
                        NavHost(
                            navController = navController,
                            startDestination = Route.Router.name,
                            route = Route.Root.name,
                        ) {
                            routerNavGraph(navController = navController)
                            authNavGraph(navController = navController)
                            appNavGraph(navController = navController)
                        }
                    }
                }
            }
        }
    }
}