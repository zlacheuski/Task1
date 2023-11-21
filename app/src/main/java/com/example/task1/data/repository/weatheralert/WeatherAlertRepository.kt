package com.example.task1.data.repository.weatheralert

import com.example.task1.data.model.weatheralert.WeatherAlertRemote
import com.example.task1.data.repository.Resource
import kotlinx.coroutines.flow.Flow

interface WeatherAlertRepository {

    suspend fun getWeatherAlertsList(): Flow<Resource<WeatherAlertRemote>>
}