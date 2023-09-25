package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response


import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.BackUrlsResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ItemResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.MetadataResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.PayerResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.PaymentMethodsResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.RedirectUrlsResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ShipmentsResponse
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PreferencesResponse(
    @Json(name = "additional_info")
    val additionalInfo: String?,
    @Json(name = "auto_return")
    val autoReturn: String?,
    @Json(name = "back_urls")
    val backUrlsResponse: BackUrlsResponse?,
    @Json(name = "binary_mode")
    val binaryMode: Boolean?,
    @Json(name = "client_id")
    val clientId: String?,
    @Json(name = "collector_id")
    val collectorId: Int?,
    @Json(name = "coupon_code")
    val couponCode: Any?,
    @Json(name = "coupon_labels")
    val couponLabels: Any?,
    @Json(name = "date_created")
    val dateCreated: String?,
    @Json(name = "date_of_expiration")
    val dateOfExpiration: Any?,
    @Json(name = "expiration_date_from")
    val expirationDateFrom: Any?,
    @Json(name = "expiration_date_to")
    val expirationDateTo: Any?,
    @Json(name = "expires")
    val expires: Boolean?,
    @Json(name = "external_reference")
    val externalReference: String?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "init_point")
    val initPoint: String?,
    @Json(name = "internal_metadata")
    val internalMetadata: Any?,
    @Json(name = "items")
    val itemResponses: List<ItemResponse>,
    @Json(name = "last_updated")
    val lastUpdated: Any?,
    @Json(name = "marketplace")
    val marketplace: String?,
    @Json(name = "marketplace_fee")
    val marketplaceFee: Int?,
    @Json(name = "metadata")
    val metadataResponse: MetadataResponse?,
    @Json(name = "notification_url")
    val notificationUrl: Any?,
    @Json(name = "operation_type")
    val operationType: String?,
    @Json(name = "payer")
    val payerResponse: PayerResponse?,
    @Json(name = "payment_methods")
    val paymentMethodsResponse: PaymentMethodsResponse?,
    @Json(name = "processing_modes")
    val processingModes: Any?,
    @Json(name = "product_id")
    val productId: Any?,
    @Json(name = "redirect_urls")
    val redirectUrlsResponse: RedirectUrlsResponse?,
    @Json(name = "sandbox_init_point")
    val sandboxInitPointResponse: String?,
    @Json(name = "shipments")
    val shipmentsResponse: ShipmentsResponse?,
    @Json(name = "site_id")
    val siteIdResponse: String?,
    @Json(name = "total_amount")
    val totalAmountResponse: Any?
)