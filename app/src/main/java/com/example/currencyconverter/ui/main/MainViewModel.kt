package com.example.currencyconverter.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.api.CurrencyObject
import com.example.currencyconverter.models.Currency
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _currencyList = MutableLiveData<List<Currency>>()
    val currencyList: LiveData<List<Currency>>
        get() = _currencyList


    fun fetchDataCoroutines(){
        viewModelScope.launch {
            val response = CurrencyObject.retrofitCurrencyService.getAllCurrenciesCoroutines()
            if (response.isSuccessful){
                _currencyList.value = response.body()
            }
        }
    }





}