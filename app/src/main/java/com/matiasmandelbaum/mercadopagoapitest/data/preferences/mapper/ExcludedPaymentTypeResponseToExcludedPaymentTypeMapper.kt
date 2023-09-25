package com.matiasmandelbaum.mercadopagoapitest.data.preferences.mapper

import com.matiasmandelbaum.mercadopagoapitest.common.ListMapper
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ExcludedPaymentTypeResponse
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.ExcludedPaymentType
import javax.inject.Inject

class ExcludedPaymentTypeToExcludedPaymentTypeMapper @Inject constructor() :
    ListMapper<ExcludedPaymentTypeResponse, ExcludedPaymentType> {
    override fun mapList(from: List<ExcludedPaymentTypeResponse>): List<ExcludedPaymentType> {
        return from.map { mapExcludedPaymentTypeResponseToExcludedPaymentType(it) }
    }

    private fun mapExcludedPaymentTypeResponseToExcludedPaymentType(
        excludedPaymentTypeResponse: ExcludedPaymentTypeResponse
    ): ExcludedPaymentType {
        return ExcludedPaymentType(
            id = excludedPaymentTypeResponse.id
        )
    }
}