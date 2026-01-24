package com.papslabs.omdb_kmp.android.ui.details.ratings

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.papslabs.omdb_kmp.android.domain.state.RatingsScreenState
import com.papslabs.omdb_kmp.android.util.extensions.toObjectList
import com.papslabs.omdb_kmp.domain.model.Rating

class RatingsViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Global
    private val TAG = RatingsViewModel::class.java.simpleName
    var state by mutableStateOf(RatingsScreenState())
        private set

    init {
        val ratings = savedStateHandle.get<String?>("ratings")
            ?.toObjectList<Rating>()

        state = state.copy(ratings = ratings)
    }
}