package com.mycode.mykotlindemo.retrofitkotlin.model

import com.google.gson.annotations.SerializedName

data class ResponseModel(

    @SerializedName("id")
    val id: Integer,
    @SerializedName("title")
    val title: String
)