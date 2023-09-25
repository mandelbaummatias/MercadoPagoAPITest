package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShipmentsResponse(
    @Json(name = "default_shipping_method")
    val defaultShippingMethod: Any?,
    @Json(name = "receiver_address")
    val receiverAddressResponse: ReceiverAddressResponse?
)