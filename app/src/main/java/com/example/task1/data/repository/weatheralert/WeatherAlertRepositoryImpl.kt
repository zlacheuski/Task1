package com.example.task1.data.repository.weatheralert

import com.example.task1.data.api.WeatherAlertApi
import com.example.task1.data.mapper.WeatherAlertMapper
import com.example.task1.domain.model.WeatherAlertModel
import com.example.task1.domain.repo.WeatherAlertRepository
import javax.inject.Inject

class WeatherAlertRepositoryImpl @Inject constructor(
    private val api: WeatherAlertApi,
    private val weatherAlertMapper: WeatherAlertMapper
) : WeatherAlertRepository {

    override suspend fun getWeatherAlertsList(): List<WeatherAlertModel> {
        return weatherAlertMapper.mapWeatherAlertToModel(api.getCurrentJourneyAsync())
    }
}