package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemResponse(
    @Json(name = "category_id")
    val categoryId: String?,
    @Json(name = "currency_id")
    val currencyId: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "picture_url")
    val pictureUrl: String?,
    @Json(name = "quantity")
    val quantity: Int?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "unit_price")
    val unitPrice: Int?
)