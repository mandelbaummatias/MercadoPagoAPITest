package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.components

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemRequest(
    @Json(name = "title") val titleRequest: String,
    @Json(name = "description") val descriptionRequest: String,
    @Json(name = "picture_url") val pictureUrlRequest: String,
    @Json(name = "category_id") val categoryIdRequest: String,
    @Json(name = "quantity") val quantityRequest: Int,
    @Json(name = "currency_id") val currencyIdRequest: String,
    @Json(name = "unit_price") val unitPriceRequest: Int
)

