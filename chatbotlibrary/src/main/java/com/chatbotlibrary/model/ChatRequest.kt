package com.chatbotlibrary.model


data class OpenAIRequest(

    val model: String,

    val messages: List<Message>
)

data class Message(

    val role: String,

    val content: String
)