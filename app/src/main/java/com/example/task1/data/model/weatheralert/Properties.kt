package com.example.task1.data.model.weatheralert

import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("@id")
    val annotatedId: String,
    @SerializedName("@type")
    val type: String,
    val affectedZones: List<String>,
    val areaDesc: String,
    val category: String,
    val certainty: String,
    val description: String,
    val effective: String,
    val ends: String?,
    val event: String,
    val expires: String,
    val geocode: Geocode,
    val headline: String,
    val id: String,
    val instruction: String,
    val messageType: String,
    val onset: String,
    val parameters: Parameters,
    val references: List<Any>,
    val response: String,
    val sender: String,
    val senderName: String,
    val sent: String,
    val severity: String,
    val status: String,
    val urgency: String
)