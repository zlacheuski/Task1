package com.example.task1.data.repository.weatheralert

import com.example.task1.data.model.weatheralert.WeatherAlert
import com.example.task1.data.repository.Resource
import kotlinx.coroutines.flow.Flow

interface IWeatherAlertRepository {

    suspend fun getWeatherAlertsList(): Flow<Resource<WeatherAlert>>
}