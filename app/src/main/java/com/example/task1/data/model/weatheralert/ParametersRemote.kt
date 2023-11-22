package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

class ParametersRemote(
    @SerializedName("AWIPSidentifier")
    val AWIPSidentifier: List<String>,
    @SerializedName("BLOCKCHANNEL")
    val BLOCKCHANNEL: List<String>,
    @SerializedName("EAS-ORG")
    val EASORG: List<String>,
    @SerializedName("NWSheadline")
    val NWSheadline: List<String>,
    @SerializedName("VTEC")
    val VTEC: List<String>,
    @SerializedName("WMOidentifier")
    val WMOidentifier: List<String>,
    @SerializedName("eventEndingTime")
    val eventEndingTime: List<String>,
    @SerializedName("eventMotionDescription")
    val eventMotionDescription: List<String>,
    @SerializedName("expiredReferences")
    val expiredReferences: List<String>,
    @SerializedName("waterspoutDetection")
    val waterspoutDetection: List<String>
)