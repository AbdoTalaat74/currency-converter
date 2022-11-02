package com.example.currencyconverter.models

import com.squareup.moshi.JsonClass
import com.google.gson.annotations.SerializedName;

@JsonClass(generateAdapter = true)
data class User(

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String,

    @SerializedName("phoneNumber")
    val phoneNumber: String?

)
