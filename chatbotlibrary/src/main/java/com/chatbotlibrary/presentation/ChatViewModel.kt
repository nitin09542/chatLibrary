package com.chatbotlibrary.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chatbotlibrary.model.ChatMessage
import com.chatbotlibrary.network.ChatRepository
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val repository = ChatRepository()

    var messages by mutableStateOf<List<ChatMessage>>(
        emptyList()
    )
        private set

    var isTyping by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(
        null
    )
        private set

    fun sendMessage(text: String) {

        if (text.isBlank()) return

        if (isTyping) return

        val userMessage = ChatMessage(
            message = text.trim(),
            isUser = true
        )

        messages = messages + userMessage

        isTyping = true

        errorMessage = null

        viewModelScope.launch {

            try {

                val response =
                    repository.sendMessage(text)

                val botMessage = ChatMessage(
                    message = response,
                    isUser = false
                )

                messages = messages + botMessage

            } catch (e: Exception) {

                errorMessage =
                    e.message ?: "Unknown error"

                messages = messages + ChatMessage(
                    message = "Something went wrong",
                    isUser = false
                )
            }

            isTyping = false
        }
    }

    fun clearChat() {

        messages = emptyList()
    }
}