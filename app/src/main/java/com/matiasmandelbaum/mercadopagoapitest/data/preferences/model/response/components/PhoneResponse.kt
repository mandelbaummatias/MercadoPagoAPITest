package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PhoneResponse(
    @Json(name = "area_code")
    val areaCode: String?,
    @Json(name = "number")
    val number: String?
)