package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class RetrieveContextRequest(val query: String, val document_path: String)
data class RetrieveContextResponse(val context: String?)

data class GenerateQARequest(val context: String)
data class GenerateQAResponse(val qa: String?)

data class TranslateRequest(val text: String)
data class TranslateResponse(val translated_text: String?)

data class ConvertSpeechRequest(val text: String)
data class ConvertSpeechResponse(val message: String?)

interface ApiService {
    @POST("/retrieve")
    fun retrieveContext(@Body request: RetrieveContextRequest): Call<RetrieveContextResponse>

    @POST("/generate_qa")
    fun generateQA(@Body request: GenerateQARequest): Call<GenerateQAResponse>

    @POST("/translate")
    fun translate(@Body request: TranslateRequest): Call<TranslateResponse>

    @POST("/convert")
    fun convertSpeech(@Body request: ConvertSpeechRequest): Call<ConvertSpeechResponse>
}
