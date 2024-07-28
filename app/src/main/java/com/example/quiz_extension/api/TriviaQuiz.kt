package com.example.currencycon.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TriviaApi {

    @GET("/api.php")
    suspend fun getQuestions(
        @Query("amount") amount: Int,
    ) : Response<Trivia>
}