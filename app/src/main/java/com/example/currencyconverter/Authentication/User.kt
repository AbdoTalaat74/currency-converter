package com.example.currencyconverter.Authentication

import com.squareup.moshi.JsonClass
import com.google.gson.annotations.SerializedName;

@JsonClass(generateAdapter = false)
data class User(

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("phoneNumber")
    val phoneNumber: String?

)
