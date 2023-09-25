package com.matiasmandelbaum.mercadopagoapitest.domain.repository

import com.matiasmandelbaum.mercadopagoapitest.common.Result
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.Preferences
import com.matiasmandelbaum.mercadopagoapitest.domain.model.subscription.Subscription

interface MercadoPagoRepository {
    suspend fun createPreferences(): Result<Preferences>
    suspend fun createSubscription(): Result<Subscription>
}