package com.matiasmandelbaum.mercadopagoapitest.ui.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matiasmandelbaum.mercadopagoapitest.common.Result
import com.matiasmandelbaum.mercadopagoapitest.domain.model.preferences.Preferences
import com.matiasmandelbaum.mercadopagoapitest.domain.model.subscription.Subscription
import com.matiasmandelbaum.mercadopagoapitest.domain.usecase.CreatePreferenceUseCase
import com.matiasmandelbaum.mercadopagoapitest.domain.usecase.CreateSubscriptionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createPreferenceUseCase: CreatePreferenceUseCase,
    private val createSubscriptionUseCase: CreateSubscriptionUseCase
) : ViewModel() {

    private val _preferences: MutableLiveData<Result<Preferences>> = MutableLiveData()
    val preferences: LiveData<Result<Preferences>> = _preferences

    private val _subscription: MutableLiveData<Result<Subscription>> = MutableLiveData()
    val subscription: LiveData<Result<Subscription>> = _subscription


    fun createPreferences() {
        _preferences.value = Result.Loading
        viewModelScope.launch {
            val result = createPreferenceUseCase()
            _preferences.postValue(result)
        }
    }

    fun createSubscription() {
        _subscription.value = Result.Loading
        viewModelScope.launch {
            val result = createSubscriptionUseCase()
            _subscription.postValue(result)
        }
    }


}