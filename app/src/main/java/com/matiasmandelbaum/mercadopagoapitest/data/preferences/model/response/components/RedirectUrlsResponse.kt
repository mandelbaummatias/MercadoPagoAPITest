package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RedirectUrlsResponse(
    @Json(name = "failure")
    val failure: String?,
    @Json(name = "pending")
    val pending: String?,
    @Json(name = "success")
    val success: String?
)