package com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PaymentMethodsResponse(
    @Json(name = "default_card_id")
    val defaultCardId: Any?,
    @Json(name = "default_installments")
    val defaultInstallments: Any?,
    @Json(name = "default_payment_method_id")
    val defaultPaymentMethodId: Any?,
    @Json(name = "excluded_payment_methods")
    val excludedPaymentMethodResponses: List<ExcludedPaymentMethodResponse>,
    @Json(name = "excluded_payment_types")
    val excludedPaymentTypeResponses: List<ExcludedPaymentTypeResponse>,
    @Json(name = "installments")
    val installments: Any?
)