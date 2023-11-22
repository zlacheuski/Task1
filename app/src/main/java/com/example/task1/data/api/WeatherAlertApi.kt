package com.example.task1.data.api

import com.example.task1.data.model.weatheralert.WeatherAlertRemote
import retrofit2.http.GET

interface WeatherAlertApi {

    @GET("/alerts/active?status=actual&message_type=alert")
    suspend fun getCurrentJourneyAsync(): WeatherAlertRemote
}