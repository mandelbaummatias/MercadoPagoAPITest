package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.components

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BackUrlsRequest(
    @Json(name = "failure") val failureRequest: String,
    @Json(name = "pending") val pendingRequest: String,
    @Json(name = "success") val successRequest: String
)