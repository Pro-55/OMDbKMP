package com.papslabs.omdb_kmp.android.domain.state

import com.papslabs.omdb_kmp.domain.model.Content
import com.papslabs.omdb_kmp.domain.model.ShortContent

data class DetailsScreenState(
    val id: String? = null,
    val shortContent: ShortContent? = null,
    val content: Content? = null
)