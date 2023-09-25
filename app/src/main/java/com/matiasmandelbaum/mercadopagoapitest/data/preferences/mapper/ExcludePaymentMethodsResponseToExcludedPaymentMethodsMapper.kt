package com.matiasmandelbaum.mercadopagoapitest.data.preferences.mapper

import com.matiasmandelbaum.mercadopagoapitest.common.ListMapper
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ExcludedPaymentMethodResponse
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.ExcludedPaymentMethod
import javax.inject.Inject

class ExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper @Inject constructor() :
    ListMapper<ExcludedPaymentMethodResponse, ExcludedPaymentMethod> {
    override fun mapList(from: List<ExcludedPaymentMethodResponse>): List<ExcludedPaymentMethod> {
        return from.map { mapExcludedPaymentMethodResponseToExcludedPaymentMethod(it) }
    }

    private fun mapExcludedPaymentMethodResponseToExcludedPaymentMethod(
        excludedPaymentMethodResponse: ExcludedPaymentMethodResponse
    ): ExcludedPaymentMethod {
        return ExcludedPaymentMethod(
            id = excludedPaymentMethodResponse.id
        )
    }
}