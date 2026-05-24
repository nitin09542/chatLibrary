package com.chatbotlibrary.chatSupport.data.ui


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.chatbotlibrary.chatSupport.data.ChatMessage

class ChatViewModel : ViewModel() {

    val messages = mutableStateListOf<ChatMessage>()

    init {
        startConversation()
    }

    private fun startConversation() {

        messages.add(
            ChatMessage.TextMessage(
                message = "Hello 👋 Welcome to Support",
                isBot = true
            )
        )

        messages.add(
            ChatMessage.OptionMessage(
                title = "How can we help you?",
                options = listOf(
                    "Payment Problem",
                    "Order Issue",
                    "Refund Status",
                    "Talk to Support"
                )
            )
        )
    }

    fun onOptionSelected(option: String) {

        // User Message
        messages.add(
            ChatMessage.TextMessage(
                message = option,
                isBot = false
            )
        )

        when(option) {

            "Payment Problem" -> {

                messages.add(
                    ChatMessage.OptionMessage(
                        title = "Select Payment Issue",
                        options = listOf(
                            "UPI Failed",
                            "Money Deducted",
                            "Card Failed"
                        )
                    )
                )
            }

            "UPI Failed" -> {

                messages.add(
                    ChatMessage.TextMessage(
                        message = "Please retry after 5 minutes.",
                        isBot = true
                    )
                )
            }

            "Money Deducted" -> {

                messages.add(
                    ChatMessage.TextMessage(
                        message = "Your amount will be refunded within 24 hours.",
                        isBot = true
                    )
                )
            }

            "Card Failed" -> {

                messages.add(
                    ChatMessage.TextMessage(
                        message = "Please check your card limit.",
                        isBot = true
                    )
                )
            }

            "Order Issue" -> {

                messages.add(
                    ChatMessage.TextMessage(
                        message = "Please share your Order ID.",
                        isBot = true
                    )
                )
            }

            "Refund Status" -> {

                messages.add(
                    ChatMessage.TextMessage(
                        message = "Refund normally takes 5-7 business days.",
                        isBot = true
                    )
                )
            }

            "Talk to Support" -> {

                messages.add(
                    ChatMessage.TextMessage(
                        message = "Connecting you to support agent...",
                        isBot = true
                    )
                )
            }
        }
    }
}