package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

class FeatureRemote(
    @SerializedName("geometry")
    val geometry: GeometryRemote,
    @SerializedName("id")
    val id: String,
    @SerializedName("properties")
    val properties: PropertiesRemote,
    @SerializedName("type")
    val type: String
)