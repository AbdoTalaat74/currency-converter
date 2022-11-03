package com.example.currencyconverter.api

import com.example.currencyconverter.models.Currency
import com.example.currencyconverter.models.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface CurrencyInterface {
    @GET("/api/Currency/GetAllCurrencies")
    fun getAllCurrencies(): Call<List<Currency>>

    @POST("/api/Currency/AddCurrency")
    fun addCurrency(@Body currency: Currency) : Call<Currency>

}

interface UserAuthenticationInterface {
    @POST("/api/Account/Register")
    fun register(@Body user: User): Call<User>

    @POST("/api/Account/Login")
    fun login(@Body user: User): Call<User>
}


var gson: Gson = GsonBuilder().setLenient().create()

val retrofit: Retrofit =
    Retrofit.Builder().baseUrl("http://currency-converter.somee.com").addConverterFactory(
        GsonConverterFactory.create(
            gson
        )
    ).build()

val retrofit3: Retrofit =
    Retrofit.Builder().baseUrl("http://currency-converter.somee.com").addConverterFactory(
        GsonConverterFactory.create(
            gson
        )
    ).build()


object UserAuthentication {
    val retrofitUserService: UserAuthenticationInterface by lazy {
        retrofit.create(
            UserAuthenticationInterface::class.java
        )
    }
}

object CurrencyObject {
    val retrofitCurrencyService: CurrencyInterface by lazy {
        retrofit3.create(CurrencyInterface::class.java)
    }
}




