package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReceiverAddressResponse(
    @Json(name = "apartment")
    val apartment: String?,
    @Json(name = "city_name")
    val cityName: Any?,
    @Json(name = "country_name")
    val countryName: Any?,
    @Json(name = "floor")
    val floor: String?,
    @Json(name = "state_name")
    val stateName: Any?,
    @Json(name = "street_name")
    val streetName: String?,
    @Json(name = "street_number")
    val streetNumber: Any?,
    @Json(name = "zip_code")
    val zipCode: String?
)