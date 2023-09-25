package com.matiasmandelbaum.mercadopagoapitest.di

import com.matiasmandelbaum.mercadopagoapitest.data.MercadoPagoRepositoryImpl
import com.matiasmandelbaum.mercadopagoapitest.domain.repository.MercadoPagoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun bindMercadoPagoRepository(mercadoPagoRepository: MercadoPagoRepositoryImpl): MercadoPagoRepository
}