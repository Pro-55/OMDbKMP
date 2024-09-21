package com.papslabs.omdb_kmp.util.extensions

import com.papslabs.omdb_kmp.domain.model.DayPart
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atTime
import kotlinx.datetime.toLocalDateTime
import kotlin.test.Test
import kotlin.test.assertEquals

class DateTimeExtensionsTest {

    private val dateTime by lazy {
        Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
    }

    @Test
    fun `test part of the day for night`() {
        val time = LocalTime(
            0,
            0,
            0
        )
        val part = dateTime.date.atTime(time).getPartOfDay()
        assertEquals(part, DayPart.NIGHT)
    }

    @Test
    fun `test part of the day for morning`() {
        val time = LocalTime(
            7,
            0,
            0
        )
        val part = dateTime.date.atTime(time).getPartOfDay()
        assertEquals(part, DayPart.MORNING)
    }

    @Test
    fun `test part of the day for afternoon`() {
        val time = LocalTime(
            13,
            0,
            0
        )
        val part = dateTime.date.atTime(time).getPartOfDay()
        assertEquals(part, DayPart.AFTER_NOON)
    }

    @Test
    fun `test part of the day for evening`() {
        val time = LocalTime(
            17,
            0,
            0
        )
        val part = dateTime.date.atTime(time).getPartOfDay()
        assertEquals(part, DayPart.EVENING)
    }
}