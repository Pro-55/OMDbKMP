package com.papslabs.omdb_kmp.util.extensions

import com.papslabs.omdb_kmp.domain.model.DayPart
import kotlinx.datetime.LocalDateTime

fun LocalDateTime.getPartOfDay(): DayPart = when (hour) {
    in 6..11 -> DayPart.MORNING
    in 12..15 -> DayPart.AFTER_NOON
    in 16..21 -> DayPart.EVENING
    else -> DayPart.NIGHT
}