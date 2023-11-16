package com.example.task1.data.repository.weatheralert

import com.example.task1.data.api.WeatherAlertApi
import com.example.task1.data.model.weatheralert.WeatherAlert
import com.example.task1.data.repository.BaseRepository
import com.example.task1.data.repository.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WeatherAlertRepositoryImpl @Inject constructor(private val api: WeatherAlertApi) : BaseRepository(), IWeatherAlertRepository {

    override suspend fun getWeatherAlertsList(): Flow<Resource<WeatherAlert>> {
        return callOrError(api.getCurrentJourneyAsync())
    }
}