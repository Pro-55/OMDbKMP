package com.papslabs.omdb_kmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
    val source: String,
    val value: String
)