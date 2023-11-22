package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

class GeometryRemote(
    @SerializedName("coordinates")
    val coordinates: List<List<List<Double>>>,
    @SerializedName("type")
    val type: String
)