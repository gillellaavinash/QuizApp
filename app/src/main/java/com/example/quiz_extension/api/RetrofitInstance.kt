package com.example.currencycon.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance{

    private const val BASE_URL = "https://opentdb.com/"

    private fun getInstance() : Retrofit{
        return Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    val triviaApi : TriviaApi = getInstance().create(TriviaApi::class.java)
}