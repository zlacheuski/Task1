package com.example.task1.data.mapper

import com.example.task1.data.model.weatheralert.WeatherAlert
import com.example.task1.ui.weatheralert.model.WeatherAlertModel
import com.example.task1.ui.weatheralert.model.WeatherAlertListModel

object WeatherAlertMapper {

    fun mapWeatherAlertToModel(weatherAlert: WeatherAlert): WeatherAlertListModel {
        return WeatherAlertListModel(weatherAlert.features.map { features ->
            features.properties.let { properties ->
                WeatherAlertModel(
                    id = properties.id,
                    event = properties.event,
                    effective = properties.effective,
                    ends = properties.ends?: "Unknown",
                    senderName = properties.senderName
                )
            }
        })
    }
}