package com.matiasmandelbaum.mercadopagoapitest.di

import com.matiasmandelbaum.mercadopagoapitest.common.ListMapper
import com.matiasmandelbaum.mercadopagoapitest.common.Mapper
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.mapper.ExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.mapper.ExcludedPaymentTypeToExcludedPaymentTypeMapper
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.mapper.ItemResponseToItemMapper
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.mapper.PreferenceResponseMapperToDomain
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.PreferencesResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ExcludedPaymentMethodResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ExcludedPaymentTypeResponse
import com.matiasmandelbaum.mercadopagoapitest.data.preferences.model.response.components.ItemResponse
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.mapper.SubscriptionResponseMapperToDomain
import com.matiasmandelbaum.mercadopagoapitest.data.subscription.model.response.SubscriptionResponse
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.Preferences
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.ExcludedPaymentMethod
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.ExcludedPaymentType
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.components.Item
import com.matiasmandelbaum.mercadopagoapitest.domain.model.subscription.Subscription
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideItemResponseToItemMapper(): ListMapper<ItemResponse, Item> {
        return ItemResponseToItemMapper()
    }

    @Provides
    @Singleton
    fun provideExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper(): ListMapper<ExcludedPaymentMethodResponse, ExcludedPaymentMethod> {
        return ExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper()
    }

    @Provides
    @Singleton
    fun provideExcludedPaymentTypeToExcludedPaymentTypeMapper(): ListMapper<ExcludedPaymentTypeResponse, ExcludedPaymentType> {
        return ExcludedPaymentTypeToExcludedPaymentTypeMapper()
    }

    @Provides
    @Singleton
    fun providePreferenceResponseMapperToDomainMapper(
        itemResponseToItemMapper: ItemResponseToItemMapper,
        excludedPaymentMethodsResponseToExcludedPaymentMethodMapper: ExcludePaymentMethodsResponseToExcludedPaymentMethodsMapper,
        excludedPaymentTypeResponseToExcludedPaymentTypeMapper: ExcludedPaymentTypeToExcludedPaymentTypeMapper
    ): Mapper<PreferencesResponse, Preferences> {
        return PreferenceResponseMapperToDomain(
            itemResponseToItemMapper,
            excludedPaymentMethodsResponseToExcludedPaymentMethodMapper,
            excludedPaymentTypeResponseToExcludedPaymentTypeMapper
        )
    }

    @Provides
    @Singleton
    fun provideSubscriptionResponseMapperToDomain(): Mapper<SubscriptionResponse, Subscription> {
        return SubscriptionResponseMapperToDomain()
    }

}