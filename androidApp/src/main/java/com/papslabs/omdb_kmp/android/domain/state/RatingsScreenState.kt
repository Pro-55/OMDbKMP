package com.papslabs.omdb_kmp.android.domain.state

import com.papslabs.omdb_kmp.domain.model.Rating

data class RatingsScreenState(
    val ratings: List<Rating>? = null
)