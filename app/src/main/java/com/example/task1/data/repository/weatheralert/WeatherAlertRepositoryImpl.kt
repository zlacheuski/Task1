package com.example.task1.data.repository.weatheralert

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.task1.data.api.WeatherAlertApi
import com.example.task1.data.mapper.WeatherAlertMapper
import com.example.task1.domain.model.WeatherAlertModel
import com.example.task1.domain.repo.WeatherAlertRepository
import com.example.task1.tools.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import javax.inject.Inject

class WeatherAlertRepositoryImpl @Inject constructor(
    private val api: WeatherAlertApi,
    private val weatherAlertMapper: WeatherAlertMapper
) : WeatherAlertRepository {

    override suspend fun getWeatherAlertsList(): List<WeatherAlertModel> {
        return weatherAlertMapper.mapWeatherAlertToModel(api.getCurrentJourneyAsync())
    }

    override suspend fun getBitmapFromUri(): Bitmap? {
        return withContext(Dispatchers.IO) {
            BitmapFactory.decodeStream(
                URL(Constants.PICTURE_LINK).openConnection().getInputStream()
            )
        }
    }
}