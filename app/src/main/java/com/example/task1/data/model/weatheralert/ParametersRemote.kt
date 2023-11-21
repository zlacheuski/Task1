package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

data class ParametersRemote(
    val AWIPSidentifier: List<String>,
    val BLOCKCHANNEL: List<String>,
    @SerializedName("EAS-ORG")
    val EASORG: List<String>,
    val NWSheadline: List<String>,
    val VTEC: List<String>,
    val WMOidentifier: List<String>,
    val eventEndingTime: List<String>,
    val eventMotionDescription: List<String>,
    val expiredReferences: List<String>,
    val waterspoutDetection: List<String>
)