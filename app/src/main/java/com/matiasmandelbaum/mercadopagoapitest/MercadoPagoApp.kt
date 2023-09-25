package com.matiasmandelbaum.mercadopagoapitest

import android.app.Application
import com.matiasmandelbaum.mercadopagoapitest.core.Config
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MercadoPagoApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Config.apiKey = resources.getString(R.string.api_key)
        Config.baseUrl = resources.getString(R.string.mercadopago_api_base_url)
    }

}