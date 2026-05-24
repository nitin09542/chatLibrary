package com.chatbotlibrary.network

import com.chatbotlibrary.core.ChatBotSDK
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()

        .addInterceptor { chain ->

            val request = chain.request()
                .newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer ${ChatBotSDK.apiKey}"
                )
                .build()

            chain.proceed(request)
        }

        .addInterceptor(logging)

        .build()

    val api: ApiService by lazy {

        Retrofit.Builder()

            .baseUrl(ChatBotSDK.baseUrl)

            .client(client)

            .addConverterFactory(
                GsonConverterFactory.create()
            )

            .build()

            .create(ApiService::class.java)
    }
}