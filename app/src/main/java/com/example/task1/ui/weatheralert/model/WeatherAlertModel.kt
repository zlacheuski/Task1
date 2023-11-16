package com.example.task1.ui.weatheralert.model

data class WeatherAlertModel(
    val id: String,
    val event: String,
    val effective: String,
    val ends: String,
    val senderName: String)