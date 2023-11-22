package com.example.task1.domain.repo

import android.graphics.Bitmap
import com.example.task1.domain.model.WeatherAlertModel

interface WeatherAlertRepository {

    suspend fun getWeatherAlertsList(): List<WeatherAlertModel>
    suspend fun getBitmapFromUri(): Bitmap?
}