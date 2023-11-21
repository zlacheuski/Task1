package com.example.task1.data.mapper

import com.example.task1.data.model.weatheralert.WeatherAlertRemote
import com.example.task1.tools.extensions.formatDate
import com.example.task1.ui.weatheralert.model.WeatherAlertModel
import com.example.task1.ui.weatheralert.model.WeatherAlertListModel

object WeatherAlertMapper {

    fun mapWeatherAlertToModel(weatherAlert: WeatherAlertRemote): WeatherAlertListModel {
        return WeatherAlertListModel(weatherAlert.features.map { features ->
            features.properties.let { properties ->
                WeatherAlertModel(
                    id = properties.id,
                    event = properties.event,
                    effective = properties.effective.formatDate(),
                    ends = properties.ends?.formatDate(),
                    senderName = properties.senderName
                )
            }
        })
    }
}