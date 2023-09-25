package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class IdentificationResponse(
    @Json(name = "number")
    val number: String?,
    @Json(name = "type")
    val type: String?
)