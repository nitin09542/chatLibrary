package com.chatbotlibrary.chatSupport.data


sealed class ChatMessage {

    data class TextMessage(
        val message: String,
        val isBot: Boolean
    ) : ChatMessage()

    data class OptionMessage(
        val title: String,
        val options: List<String>
    ) : ChatMessage()
}