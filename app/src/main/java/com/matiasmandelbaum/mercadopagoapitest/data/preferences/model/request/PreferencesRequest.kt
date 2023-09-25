package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request

import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.components.BackUrlsRequest
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.components.ItemRequest
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PreferencesRequest(
    @Json(name = "payer_email") val payerEmailRequest: String?,
    @Json(name = "items") val itemRequests: List<ItemRequest>?,
    @Json(name = "back_urls") val backUrlsRequest: BackUrlsRequest?,
    @Json(name = "auto_return") val autoReturn: String?
)

