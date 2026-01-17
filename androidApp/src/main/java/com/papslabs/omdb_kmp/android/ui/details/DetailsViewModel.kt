package com.papslabs.omdb_kmp.android.ui.details

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.papslabs.omdb_kmp.android.domain.state.DetailsScreenState
import com.papslabs.omdb_kmp.android.util.extensions.toObject
import com.papslabs.omdb_kmp.domain.model.Content
import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.model.ShortContent
import com.papslabs.omdb_kmp.domain.use_case.GetDetailsUseCase
import com.papslabs.omdb_kmp.util.Constants
import com.papslabs.omdb_kmp.util.DeepLinkHelper.getDetailsDeepLink
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val getDetailsUseCase: GetDetailsUseCase
) : ViewModel() {

    // Global
    private val TAG = DetailsViewModel::class.java.simpleName
    var state by mutableStateOf(DetailsScreenState())
        private set
    var isLoading by mutableStateOf(false)
        private set
    var error by mutableStateOf<String?>(null)
        private set

    init {
        val id = savedStateHandle.get<String?>("contentId")
        val shortContent = savedStateHandle.get<String?>("shortContent")
            ?.toObject<ShortContent>()

        if (id.isNullOrEmpty() && shortContent == null) {
            error = Constants.ERROR_MESSAGE_INVALID_REQUEST
        } else {
            state = state.copy(
                id = id,
                shortContent = shortContent
            )
            getDetails(id = id ?: shortContent?.id!!)
        }
    }

    private fun getDetails(
        id: String,
        plot: String = "short"
    ) {
        getDetailsUseCase(
            id = id,
            plot = plot
        )
            .onEach {
                when (it) {
                    is Resource.Loading -> isLoading = true
                    is Resource.Success -> {
                        isLoading = false
                        state = state.copy(
                            content = it.data
                        )
                    }
                    is Resource.Error -> {
                        error = it.msg
                        isLoading = false
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    fun share(
        context: Context,
        content: Content
    ) {
        val url = getDetailsDeepLink(contentId = content.id)
        val sendIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TITLE, content.title)
            putExtra(Intent.EXTRA_TEXT, url)
            type = "text/*"
        }
        val shareIntent = Intent.createChooser(sendIntent, null)
        context.startActivity(shareIntent)
    }
}