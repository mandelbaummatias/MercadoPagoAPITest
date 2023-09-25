package com.matiasmandelbaum.mercadopagoapitest.data

import com.matiasmandelbaum.mercadopagoapitest.common.Result
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.mapper.PreferenceResponseMapperToDomain
import com.matiasmandelbaum.mercadopagoapitest.data.remote.MercadoPagoService
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.mapper.SubscriptionResponseMapperToDomain
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.Preferences
import com.matiasmandelbaum.mercadopagoapitest.domain.model.subscription.Subscription
import com.matiasmandelbaum.mercadopagoapitest.domain.repository.MercadoPagoRepository
import javax.inject.Inject

class MercadoPagoRepositoryImpl @Inject constructor(
    private val remote: MercadoPagoService,
    private val preferenceResponseMapperToDomain: PreferenceResponseMapperToDomain,
    private val subscriptionResponseMapperToDomain: SubscriptionResponseMapperToDomain
) : MercadoPagoRepository {

    override suspend fun createPreferences(): Result<Preferences> {
        return try {
            val response = remote.createPreferences(MercadoPagoDataSource.BODY_PREFERENCES)
            val preferencesResponse =
                response ?: return Result.Error("Response is null")

            Result.Success(preferenceResponseMapperToDomain.mapFrom(preferencesResponse))
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    override suspend fun createSubscription(): Result<Subscription> {
        return try {
            val response = remote.createSubscription(MercadoPagoDataSource.BODY_SUBSCRIPTION)
            val subscriptionResponse =
                response ?: return Result.Error("Response is null")

            Result.Success(subscriptionResponseMapperToDomain.mapFrom(subscriptionResponse))
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }
}
