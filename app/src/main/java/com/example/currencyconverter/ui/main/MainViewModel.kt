package com.example.currencyconverter.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverter.api.CurrencyObject
import com.example.currencyconverter.models.Currency
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel() : ViewModel() {
    private val _currencyList = MutableLiveData<List<Currency>>()
    val currencyList: LiveData<List<Currency>>
        get() = _currencyList


    fun getCurrencies() {
        _currencyList.value = fetchCurrencies()
    }


    private fun fetchCurrencies(): List<Currency> {
        var data: List<Currency> = emptyList()
        CurrencyObject.retrofitCurrencyService.getAllCurrencies()
            .enqueue(object : Callback<List<Currency>> {
                override fun onResponse(
                    call: Call<List<Currency>>,
                    response: Response<List<Currency>>
                ) {
                    Log.e("CurrencyViewModel", "Success")
                    data = response.body()!!
                    _currencyList.value = response.body()
                }

                override fun onFailure(call: Call<List<Currency>>, t: Throwable) {
                    Log.e("CurrencyViewModel", "Failed")
                }

            })
        return data
    }
}