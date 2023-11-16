package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

data class Geocode(
    @SerializedName("SAME")
    val same: List<String>,
    @SerializedName("UGC")
    val ugc: List<String>
)