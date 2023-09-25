package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PayerResponse(
    @Json(name = "address")
    val addressResponse: AddressResponse?,
    @Json(name = "date_created")
    val dateCreated: Any?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "identification")
    val identificationResponse: IdentificationResponse?,
    @Json(name = "last_purchase")
    val lastPurchase: Any?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "phone")
    val phoneResponse: PhoneResponse?,
    @Json(name = "surname")
    val surname: String?
)