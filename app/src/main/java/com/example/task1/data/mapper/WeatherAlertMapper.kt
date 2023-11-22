package com.example.task1.data.mapper

import com.example.task1.data.model.weatheralert.WeatherAlertRemote
import com.example.task1.domain.model.WeatherAlertModel
import com.example.task1.tools.extensions.formatDate
import javax.inject.Inject

class WeatherAlertMapper @Inject constructor() {

    fun mapWeatherAlertToModel(
        weatherAlert: WeatherAlertRemote
    ): List<WeatherAlertModel> {
        return weatherAlert.features
            .map { it.properties }
            .map { properties ->
                WeatherAlertModel(
                    id = properties.id,
                    event = properties.event,
                    effective = properties.effective.formatDate(),
                    ends = properties.ends?.formatDate(),
                    senderName = properties.senderName
                )
            }
    }
}