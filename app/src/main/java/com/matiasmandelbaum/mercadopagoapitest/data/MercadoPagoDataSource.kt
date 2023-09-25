package com.matiasmandelbaum.mercadopagoapitest.data

import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.PreferencesRequest
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.components.BackUrlsRequest
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.request.components.ItemRequest
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.model.request.SubscriptionRequest
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.model.request.components.AutoRecurringRequest

class MercadoPagoDataSource {

    companion object {
        val BODY_PREFERENCES = PreferencesRequest(
            payerEmailRequest = "", //Your buyer user
            itemRequests = listOf(
                ItemRequest(
                    titleRequest = "Learnings",
                    descriptionRequest = "A learning item",
                    pictureUrlRequest = "http://www.myapp.com/myimage.jpg",
                    categoryIdRequest = "learnings",
                    quantityRequest = 1,
                    currencyIdRequest = "ARS",
                    unitPriceRequest = 3
                )
            ),
            backUrlsRequest = BackUrlsRequest(
                failureRequest = "app://home",
                pendingRequest = "app://home",
                successRequest = "app://home"
            ),
            autoReturn = "approved"
        )

        val BODY_SUBSCRIPTION = SubscriptionRequest(
            autoRecurringRequest = AutoRecurringRequest(
                currencyIdRequest = "ARS",
                frequencyRequest = 1,
                frequencyTypeRequest = "months",
                transactionAmountRequest = 5
            ),
            backUrlRequest = "https://mercadopago.com.ar",
            payerEmailRequest = "", //Your buyer user
            reasonRequest = "Learning subscription"
        )
    }
}
