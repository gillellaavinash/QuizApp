package com.example.quiz_extension.api

import retrofit2.http.GET

interface QuizService {

    @GET("v2/questions")
    suspend fun getQuestions() : QuizResponse


}