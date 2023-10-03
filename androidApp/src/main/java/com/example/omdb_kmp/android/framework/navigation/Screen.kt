package com.example.omdb_kmp.android.framework.navigation

sealed class Screen(val route: String) {
    data object Router : Screen(route = "screen_router")
    data object Signup : Screen(route = "screen_signup")
    data object Home : Screen(route = "screen_home")
    data object Search : Screen(route = "screen_search")
    data object Details : Screen(route = "screen_details")
}