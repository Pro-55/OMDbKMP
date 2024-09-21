package com.papslabs.omdb_kmp.android.domain.state

import com.papslabs.omdb_kmp.domain.model.User

data class HomeScreenState(
    val greeting: String = "",
    val user: User? = null
)