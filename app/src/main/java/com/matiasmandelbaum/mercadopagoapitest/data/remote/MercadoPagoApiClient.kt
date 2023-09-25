package com.matiasmandelbaum.mercadopagoapitest.data.remote

import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.PreferencesRequest
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.PreferencesResponse
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.model.request.SubscriptionRequest
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.model.response.SubscriptionResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MercadoPagoApiClient {
    @POST("checkout/preferences")
    suspend fun createPreferences(@Body request: PreferencesRequest): Response<PreferencesResponse>

    @POST("preapproval")
    suspend fun createSubscription(@Body request: SubscriptionRequest): Response<SubscriptionResponse>

}

