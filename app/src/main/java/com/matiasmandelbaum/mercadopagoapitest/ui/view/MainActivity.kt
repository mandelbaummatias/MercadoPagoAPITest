package com.matiasmandelbaum.mercadopagoapitest.ui.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent
import com.matiasmandelbaum.mercadopagoapitest.R
import com.matiasmandelbaum.mercadopagoapitest.common.Result
import com.matiasmandelbaum.mercadopagoapitest.ui.view.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MainActivity"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.preferences.observe(this) {
            when (it) {
                is Result.Success -> {
                    val url = it.data.initPoint
                    val intent = CustomTabsIntent.Builder()
                        .build()
                    intent.launchUrl(this@MainActivity, Uri.parse(url))
                }

                is Result.Error -> {
                    Toast.makeText(
                        this,
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    Unit
                }
            }
        }

        viewModel.subscription.observe(this) {
            when (it) {
                is Result.Success -> {
                    val url = it.data.initPoint
                    val intent = CustomTabsIntent.Builder()
                        .build()
                    intent.launchUrl(this@MainActivity, Uri.parse(url))
                }

                is Result.Error -> {
                    Toast.makeText(
                        this,
                        it.message,
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    Unit
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent?.action == Intent.ACTION_VIEW) {
            val data = intent.data
            data?.let {

                val status = data.getQueryParameter("status")
                val collectionStatus = data.getQueryParameter("collection_status")
                val preferenceId = data.getQueryParameter("preference_id")
                val siteId = data.getQueryParameter("site_id")
                val externalReference = data.getQueryParameter("external_reference")
                val merchantOrderId = data.getQueryParameter("merchant_order_id")
                val collectionId = data.getQueryParameter("collection_id")
                val paymentId = data.getQueryParameter("payment_id")
                val paymentType = data.getQueryParameter("payment_type")
                val processingMode = data.getQueryParameter("processing_mode")

                Log.d(TAG, "Status: $status")
                Log.d(TAG, "Collection Status: $collectionStatus")
                Log.d(TAG, "Preference ID: $preferenceId")
                Log.d(TAG, "Site ID: $siteId")
                Log.d(TAG, "External Reference: $externalReference")
                Log.d(TAG, "Merchant Order ID: $merchantOrderId")
                Log.d(TAG, "Collection ID: $collectionId")
                Log.d(TAG, "Payment ID: $paymentId")
                Log.d(TAG, "Payment Type: $paymentType")
                Log.d(TAG, "Processing Mode: $processingMode")
            }
        }
    }
}