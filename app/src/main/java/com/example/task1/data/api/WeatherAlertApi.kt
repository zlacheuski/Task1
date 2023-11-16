package com.example.task1.data.api

import com.example.task1.data.model.weatheralert.WeatherAlert
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface WeatherAlertApi {

    @GET("/alerts/active?status=actual&message_type=alert")
    fun getCurrentJourneyAsync(): Deferred<Response<WeatherAlert>>
}