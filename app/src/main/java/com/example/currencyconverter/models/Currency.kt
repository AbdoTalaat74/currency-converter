package com.example.currencyconverter.models

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Currency(

    @SerializedName("id")
    val id: Int?,

    @SerializedName("name")
    val name: String,

    @SerializedName("sign")
    val sign: String,

    @SerializedName("valueAgainstUsd")
    val valueAgainstUsd:Float?
)