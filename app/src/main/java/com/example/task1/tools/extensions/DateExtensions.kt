package com.example.task1.tools.extensions

import com.example.task1.tools.Constants.DATE_TIME_PATTERN
import com.example.task1.tools.Constants.UNKNOWN_STATUS
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun String.formatDate(): LocalDateTime? {
    return try {
        ZonedDateTime.parse(this).toLocalDateTime()
    } catch (e: Exception) {
        null
    }
}

fun LocalDateTime?.getFormattedDate(): String {
    return this?.format(DateTimeFormatter.ofPattern(DATE_TIME_PATTERN))
        ?: UNKNOWN_STATUS
}

fun getDuration(startDate: LocalDateTime?, endDate: LocalDateTime?): String {
    return try {
        val duration = Duration.between(startDate, endDate)
        duration.run {
            val hours = toHours()
            val minutes = toMinutes() % 60
            String.format("dur. %02dH %02dm", hours, minutes)
        }
    } catch (e: Exception) {
        "(dur. $UNKNOWN_STATUS)"
    }
}