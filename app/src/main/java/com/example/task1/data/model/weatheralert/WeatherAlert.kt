package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

data class WeatherAlert(
    @SerializedName("@context")
    val context: List<Any>,
    val features: List<Feature>,
    val title: String,
    val type: String,
    val updated: String
)