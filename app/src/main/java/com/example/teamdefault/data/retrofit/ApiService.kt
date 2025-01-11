package com.example.teamdefault.data.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

//interface ApiService {
//
//}

interface OpenAIService {
    @POST("v1/completions")
    suspend fun getAnswer(@Body request: QuestionRequest): Response<AnswerResponse>
}

data class QuestionRequest(
    val prompt: String,
    val max_tokens: Int = 100
)

data class AnswerResponse(
    val choices: List<Choice>
)

data class Choice(
    val text: String
)
