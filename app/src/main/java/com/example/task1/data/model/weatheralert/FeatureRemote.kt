package com.example.task1.data.model.weatheralert

data class FeatureRemote(
    val geometry: GeometryRemote,
    val id: String,
    val properties: PropertiesRemote,
    val type: String
)