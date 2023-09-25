package com.matiasmandelbaum.mercadopagoapitest.di

import com.matiasmandelbaum.mercadopagoapitest.core.Config
import com.matiasmandelbaum.mercadopagoapitest.core.InterceptorCustom
import com.matiasmandelbaum.mercadopagoapitest.data.remote.MercadoPagoApiClient
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private var client: OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
            .addInterceptor(InterceptorCustom)

    }.build()


    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val apiKey = Config.apiKey
        val baseUrl = Config.baseUrl

        client.newBuilder().addNetworkInterceptor(Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $apiKey")
                .build()
            chain.proceed(request)
        })

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Singleton
    @Provides
    fun provideMercadoPagoApiClient(retrofit: Retrofit): MercadoPagoApiClient {
        return retrofit.create(MercadoPagoApiClient::class.java)
    }
}