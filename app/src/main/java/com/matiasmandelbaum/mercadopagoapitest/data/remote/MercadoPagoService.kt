package com.matiasmandelbaum.mercadopagoapitest.data.remote

import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.PreferencesRequest
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.PreferencesResponse
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.model.request.SubscriptionRequest
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.model.response.SubscriptionResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MercadoPagoService @Inject constructor(private val service: MercadoPagoApiClient) {

    suspend fun createPreferences(preferencesRequest: PreferencesRequest): PreferencesResponse? {
        return withContext(Dispatchers.IO) {
            val response = service.createPreferences(preferencesRequest)
            response.body()
        }
    }

    suspend fun createSubscription(subscriptionRequest: SubscriptionRequest): SubscriptionResponse? {
        return withContext(Dispatchers.IO) {
            val response = service.createSubscription(subscriptionRequest)
            response.body()
        }
    }

}