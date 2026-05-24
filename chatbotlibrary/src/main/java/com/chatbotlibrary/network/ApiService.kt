package com.chatbotlibrary.network

import com.chatbotlibrary.model.OpenAIRequest
import com.chatbotlibrary.model.OpenAIResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("v1/chat/completions")
    suspend fun sendMessage(

        @Body request: OpenAIRequest

    ): OpenAIResponse
}