package com.example.task1.data.model.weatheralert

data class Feature(
    val geometry: Geometry,
    val id: String,
    val properties: Properties,
    val type: String
)