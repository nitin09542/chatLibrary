package com.chatbotlibrary.core

import androidx.compose.ui.graphics.Color

data class ChatBotConfig(

    val primaryColor: Color = Color(0xFF6200EE),

    val userBubbleColor: Color = Color(0xFF6200EE),

    val botBubbleColor: Color = Color(0xFFEAEAEA),

    val botName: String = "AI Bot",

    val enableTypingIndicator: Boolean = true
)