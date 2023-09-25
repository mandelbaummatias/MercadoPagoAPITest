package com.matiasmandelbaum.mercadopagoapitest.domain.usecase

import com.matiasmandelbaum.mercadopagoapitest.common.Result
import com.matiasmandelbaum.mercadopagoapitest.domain.model.subscription.Subscription
import com.matiasmandelbaum.mercadopagoapitest.domain.repository.MercadoPagoRepository
import javax.inject.Inject

class CreateSubscriptionUseCase @Inject constructor(private val mercadoPagoRepository: MercadoPagoRepository) {
    suspend operator fun invoke(): Result<Subscription> {
        return mercadoPagoRepository.createSubscription()
    }
}