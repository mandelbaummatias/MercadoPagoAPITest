package com.matiasmandelbaum.mercadopagoapitest.domain.usecase

import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.Preferences
import com.matiasmandelbaum.mercadopagoapitest.domain.repository.MercadoPagoRepository
import com.matiasmandelbaum.mercadopagoapitest.common.Result
import javax.inject.Inject

class CreatePreferenceUseCase @Inject constructor(private val mercadoPagoRepository: MercadoPagoRepository) {
    suspend operator fun invoke(): Result<Preferences> {
        return mercadoPagoRepository.createPreferences()
    }
}