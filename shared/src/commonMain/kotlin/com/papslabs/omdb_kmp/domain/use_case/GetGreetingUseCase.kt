package com.papslabs.omdb_kmp.domain.use_case

import com.papslabs.omdb_kmp.domain.repository.MainRepository
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
class GetGreetingUseCase(
    private val repository: MainRepository,
) {
    suspend operator fun invoke(
        userName: String?
    ): String = repository.getGreeting(
        userName = userName,
        dateTime = Clock.System
            .now()
            .toLocalDateTime(
                timeZone = TimeZone.currentSystemDefault()
            )
    )
}