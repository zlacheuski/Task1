package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

class WeatherAlertRemote(
    @SerializedName("@context")
    val context: List<Any>,
    @SerializedName("features")
    val features: List<FeatureRemote>,
    @SerializedName("title")
    val title: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("updated")
    val updated: String
)