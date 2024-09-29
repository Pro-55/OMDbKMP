package com.papslabs.omdb_kmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ShortContent(
    val id: String,
    val title: String,
    val year: String,
    val poster: String?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ShortContent

        if (id != other.id) return false
        if (title != other.title) return false
        if (year != other.year) return false
        if (poster != other.poster) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + year.hashCode()
        result = 31 * result + (poster?.hashCode() ?: 0)
        return result
    }
}