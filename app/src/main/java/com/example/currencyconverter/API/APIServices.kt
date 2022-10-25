package com.example.currencyconverter.API

import com.example.currencyconverter.Models.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


var gson: Gson = GsonBuilder()
    .setLenient()
    .create()

val retrofit: Retrofit =
    Retrofit.Builder().baseUrl("http://currency-converter.somee.com").addConverterFactory(
        GsonConverterFactory.create(
            gson
        )
    ).build()

interface UserAuthenticationInterface {
    @POST("/api/Account/Register")
    fun register(@Body user: User): Call<User>

    @POST("/api/Account/Login")
    fun login(@Body user: User): Call<User>
}

object UserAuthentication {
    val retrofitService: UserAuthenticationInterface by lazy {
        retrofit.create(
            UserAuthenticationInterface::class.java
        )
    }
}


