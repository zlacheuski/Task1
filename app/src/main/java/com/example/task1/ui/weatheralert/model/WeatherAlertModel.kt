package com.example.task1.ui.weatheralert.model

import com.example.task1.tools.extensions.getDuration
import com.example.task1.tools.extensions.getFormattedDate
import java.time.LocalDateTime

data class WeatherAlertModel(
    val id: String,
    val event: String,
    val effective: LocalDateTime?,
    val ends: LocalDateTime?,
    val senderName: String){

    val startDate
        get() = effective.getFormattedDate()

    val endDate
        get() = ends.getFormattedDate()

    val duration
        get() = getDuration(startDate = effective, endDate = ends)
}