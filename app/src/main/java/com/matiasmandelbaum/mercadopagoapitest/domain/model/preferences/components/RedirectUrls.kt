package com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components

data class RedirectUrls(
    val failure: String?,
    val pending: String?,
    val success: String?
)