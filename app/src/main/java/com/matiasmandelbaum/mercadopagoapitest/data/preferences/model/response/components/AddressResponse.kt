package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AddressResponse(
    @Json(name = "street_name")
    val streetName: String?,
    @Json(name = "street_number")
    val streetNumber: Any?,
    @Json(name = "zip_code")
    val zipCode: String?
)