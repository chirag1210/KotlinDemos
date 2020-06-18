package com.mycode.mykotlindemo.retrofitkotlin.retrofit

import com.mycode.mykotlindemo.retrofitkotlin.model.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("typicode/demo/posts")
    fun getPhotos(): Call<List<ResponseModel>>

}