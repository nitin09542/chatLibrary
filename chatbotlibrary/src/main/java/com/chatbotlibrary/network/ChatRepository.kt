package com.chatbotlibrary.network

import com.chatbotlibrary.model.Message
import com.chatbotlibrary.model.OpenAIRequest


class ChatRepository {

    suspend fun sendMessage(
        message: String
    ): String {

        return try {

            val response =
                RetrofitClient.api.sendMessage(

                    OpenAIRequest(

                        model = "gpt-4o-mini",

                        messages = listOf(

                            Message(
                                role = "user",
                                content = message
                            )
                        )
                    )
                )

            response.choices.firstOrNull()
                ?.message
                ?.content
                ?: "No response"

        } catch (e: Exception) {

            e.printStackTrace()

            "Something went wrong"
        }
    }
}