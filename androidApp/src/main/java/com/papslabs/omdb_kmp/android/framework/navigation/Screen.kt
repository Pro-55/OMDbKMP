package com.papslabs.omdb_kmp.android.framework.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.papslabs.omdb_kmp.domain.model.Type

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {
    data object Router: Screen(
        route = "screen_router"
    )

    data object SignUp: Screen(
        route = "screen_sign_up"
    )

    data object Home: Screen(
        route = "screen_home"
    )

    data object Search: Screen(
        route = "screen_search",
        arguments = listOf(
            navArgument(name = "category") {
                type = NavType.EnumType(Type::class.java)
            }
        )
    ) {
        fun getPath(
            category: Type? = null
        ): String = StringBuilder(route)
            .append("?")
            .append("category=")
            .append(category ?: "{category}")
            .toString()
    }

    data object Details: Screen(
        route = "screen_details"
    )

    data object FullPoster: Screen(
        route = "screen_full_screen"
    )

    data object Ratings: Screen(
        route = "screen_ratings"
    )

    data object TeamDetails: Screen(
        route = "screen_team_details"
    )

    data object Episodes: Screen(
        route = "screen_episodes"
    )
}