package com.matiasmandelbaum.mercadopagoapitest.data.preferences.mapper

import com.matiasmandelbaum.mercadopagoapitest.common.ListMapper
import com.matiasmandelbaum.mercadopagoapitest.common.Mapper
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.PreferencesResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ExcludedPaymentMethodResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ExcludedPaymentTypeResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ItemResponse
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.Preferences
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.Address
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.BackUrls
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.ExcludedPaymentMethod
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.ExcludedPaymentType
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.Identification
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.Item
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.Metadata
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.Payer
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.PaymentMethods
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.Phone
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.ReceiverAddress
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.RedirectUrls
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.Shipments
import javax.inject.Inject

class PreferenceResponseMapperToDomain @Inject constructor(
    private val itemResponseToItemMapper: ListMapper<ItemResponse, Item>,
    private val excludedPaymentMethodsResponseToExcludedPaymentMethodsMapper: ListMapper<ExcludedPaymentMethodResponse, ExcludedPaymentMethod>,
    private val excludedPaymentTypeResponseToExcludedPaymentType: ListMapper<ExcludedPaymentTypeResponse, ExcludedPaymentType>
) :
    Mapper<PreferencesResponse, Preferences> {
    override fun mapFrom(from: PreferencesResponse): Preferences {
        return Preferences(
            additionalInfo = from.additionalInfo,
            autoReturn = from.autoReturn,
            backUrls = BackUrls(
                failure = from.backUrlsResponse?.failure,
                pending = from.backUrlsResponse?.pending,
                success = from.backUrlsResponse?.success
            ),
            binaryMode = from.binaryMode,
            clientId = from.clientId,
            collectorId = from.collectorId,
            couponCode = from.couponCode,
            couponLabels = from.couponLabels,
            dateCreated = from.dateCreated,
            dateOfExpiration = from.dateOfExpiration,
            expirationDateFrom = from.expirationDateFrom,
            expirationDateTo = from.expirationDateTo,
            expires = from.expires,
            externalReference = from.externalReference,
            id = from.id,
            initPoint = from.initPoint,
            internalMetadata = from.internalMetadata,
            items = itemResponseToItemMapper.mapList(from.itemResponses),
            lastUpdated = from.lastUpdated,
            marketplace = from.marketplace,
            marketplaceFee = from.marketplaceFee,
            metadata = Metadata(from.metadataResponse?.data),
            notificationUrl = from.notificationUrl,
            operationType = from.operationType,
            payerResponse = Payer(
                address = Address(
                    streetName = from.payerResponse?.addressResponse?.streetName,
                    streetNumber = from.payerResponse?.addressResponse?.streetNumber,
                    zipCode = from.payerResponse?.addressResponse?.zipCode
                ),
                dateCreated = from.payerResponse?.dateCreated,
                email = from.payerResponse?.email,
                identification = Identification(
                    number = from.payerResponse?.identificationResponse?.number,
                    type = from.payerResponse?.identificationResponse?.type
                ),
                lastPurchase = from.payerResponse?.lastPurchase,
                name = from.payerResponse?.name,
                phone = Phone(
                    areaCode = from.payerResponse?.phoneResponse?.areaCode,
                    number = from.payerResponse?.phoneResponse?.number
                ),
                surname = from.payerResponse?.surname,
            ),
            paymentMethods = PaymentMethods(
                defaultCardId = from.paymentMethodsResponse?.defaultCardId,
                defaultInstallments = from.paymentMethodsResponse?.defaultInstallments,
                defaultPaymentMethodId = from.paymentMethodsResponse?.defaultPaymentMethodId,
                excludedPaymentMethods = from.paymentMethodsResponse?.let {
                    excludedPaymentMethodsResponseToExcludedPaymentMethodsMapper.mapList(
                        it.excludedPaymentMethodResponses
                    )
                },
                excludedPaymentTypes = from.paymentMethodsResponse?.let {
                    excludedPaymentTypeResponseToExcludedPaymentType.mapList(it.excludedPaymentTypeResponses)
                },
                installments = from.paymentMethodsResponse?.installments
            ),
            processingModes = from.processingModes,
            productId = from.productId,
            redirectUrls = RedirectUrls(
                failure = from.redirectUrlsResponse?.failure,
                pending = from.redirectUrlsResponse?.pending,
                success = from.redirectUrlsResponse?.success
            ),
            sandboxInitPoint = from.sandboxInitPointResponse,
            shipments = Shipments(
                defaultShippingMethod = from.shipmentsResponse?.defaultShippingMethod,
                receiverAddress = ReceiverAddress(
                    apartment = from.shipmentsResponse?.receiverAddressResponse?.apartment,
                    cityName = from.shipmentsResponse?.receiverAddressResponse?.cityName,
                    countryName = from.shipmentsResponse?.receiverAddressResponse?.countryName,
                    floor = from.shipmentsResponse?.receiverAddressResponse?.floor,
                    stateName = from.shipmentsResponse?.receiverAddressResponse?.stateName,
                    streetName = from.shipmentsResponse?.receiverAddressResponse?.streetName,
                    streetNumber = from.shipmentsResponse?.receiverAddressResponse?.streetNumber,
                    zipCode = from.shipmentsResponse?.receiverAddressResponse?.zipCode
                )
            ),
            siteId = from.siteIdResponse,
            totalAmount = from.totalAmountResponse
        )
    }
}