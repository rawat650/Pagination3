package com

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("quotes")
    suspend fun getQuotes(@Query("page")  page : Int):Quotes

    companion object{
        fun getInstance():Retrofit{
            return Retrofit.Builder().baseUrl("https://api.quotable.io/").addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}