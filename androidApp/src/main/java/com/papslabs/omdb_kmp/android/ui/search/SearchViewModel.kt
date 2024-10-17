package com.papslabs.omdb_kmp.android.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.papslabs.omdb_kmp.android.domain.state.SearchScreenState
import com.papslabs.omdb_kmp.domain.model.Resource
import com.papslabs.omdb_kmp.domain.model.SearchResult
import com.papslabs.omdb_kmp.domain.model.ShortContent
import com.papslabs.omdb_kmp.domain.model.Type
import com.papslabs.omdb_kmp.domain.model.update
import com.papslabs.omdb_kmp.domain.use_case.SearchContentUseCase
import com.papslabs.omdb_kmp.util.Constants
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(FlowPreview::class)
class SearchViewModel(
    savedStateHandle: SavedStateHandle,
    private val searchContentUseCase: SearchContentUseCase
): ViewModel() {

    // Global
    private val TAG = SearchViewModel::class.java.simpleName
    private val _queryFlow = MutableStateFlow("")
    private var lastSearchedQuery = ""
    private var lastSearchedPage = 0
    var state by mutableStateOf(
        SearchScreenState(
            category = savedStateHandle["category"] ?: Type.MOVIE
        )
    )
        private set
    var isLoading by mutableStateOf(false)
        private set
    var error by mutableStateOf<String?>(null)
        private set

    init {
        viewModelScope.launch {
            _queryFlow.debounce(timeoutMillis = 300L)
                .collectLatest {
                    if (it.isNotEmpty()) {
                        searchContent(
                            shouldClearResults = true,
                            query = it
                        )
                    }
                }
        }
    }

    fun onSearchQueryUpdated(query: String) {
        state = state.copy(query = query)
        _queryFlow.update { query }
    }

    fun onClearSearchQuery() {
        resetSearchResult(query = "")
        _queryFlow.update { "" }
    }

    fun searchNow() {
        searchContent(
            shouldClearResults = true,
            query = _queryFlow.value
        )
    }

    fun loadMore() {
        searchContent(
            shouldClearResults = false,
            query = _queryFlow.value
        )
    }

    fun onHold(peekContent: ShortContent) {
        state = state.copy(
            peekContent = peekContent,
            shouldPeek = true
        )
    }

    fun onRelease() {
        viewModelScope.launch {
            state = state.copy(shouldPeek = false)
        }
    }

    private fun searchContent(
        shouldClearResults: Boolean,
        query: String
    ) {
        if (shouldClearResults && lastSearchedQuery != query) {
            resetSearchResult(query = _queryFlow.value)
        }

        val size = state.result
            .search
            .size
        val page = if (size < 1) {
            1
        } else {
            size / Constants.PAGE_SIZE + 1
        }

        if (lastSearchedQuery == query && lastSearchedPage == page) {
            return
        }

        lastSearchedQuery = query
        lastSearchedPage = page
        searchContentUseCase(
            query = query.trim(),
            page = page,
            type = state.category
        )
            .onEach {
                when (it) {
                    is Resource.Loading -> isLoading = true
                    is Resource.Success -> {
                        state = state.copy(
                            result = state.result.update(data = it.data)
                        )
                        isLoading = false
                    }
                    is Resource.Error -> {
                        error = it.msg
                        isLoading = false
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun resetSearchResult(
        query: String
    ) {
        lastSearchedQuery = ""
        lastSearchedPage = 0
        state = state.copy(
            query = query,
            result = SearchResult()
        )
    }

    fun resetError() {
        error = null
    }
}