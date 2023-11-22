package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

class PropertiesRemote(
    @SerializedName("@id")
    val annotatedId: String,
    @SerializedName("@type")
    val type: String,
    @SerializedName("affectedZones")
    val affectedZones: List<String>,
    @SerializedName("areaDesc")
    val areaDesc: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("certainty")
    val certainty: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("effective")
    val effective: String,
    @SerializedName("ends")
    val ends: String?,
    @SerializedName("event")
    val event: String,
    @SerializedName("expires")
    val expires: String,
    @SerializedName("geocode")
    val geocode: GeocodeRemote,
    @SerializedName("headline")
    val headline: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("instruction")
    val instruction: String,
    @SerializedName("messageType")
    val messageType: String,
    @SerializedName("onset")
    val onset: String,
    @SerializedName("parameters")
    val parameters: ParametersRemote,
    @SerializedName("references")
    val references: List<Any>,
    @SerializedName("response")
    val response: String,
    @SerializedName("sender")
    val sender: String,
    @SerializedName("senderName")
    val senderName: String,
    @SerializedName("sent")
    val sent: String,
    @SerializedName("severity")
    val severity: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("urgency")
    val urgency: String
)