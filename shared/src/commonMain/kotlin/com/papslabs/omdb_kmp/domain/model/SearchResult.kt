package com.papslabs.omdb_kmp.domain.model

data class SearchResult(
    val search: List<ShortContent> = listOf(),
    val total: Int = 0
)

fun SearchResult.update(data: SearchResult?): SearchResult {
    if (data == null) return this
    val list = search.toMutableList()
    val new = data.search
    list.addAll(new)
    list.distinctBy { it.id }
    return copy(
        search = list,
        total = data.total
    )
}