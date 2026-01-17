package com.papslabs.omdb_kmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TeamDetails(
    val cast: String = "",
    val crew: String = "",
    val director: String = "",
    val production: String? = null
)