package com.chatbotlibrary.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.chatbotlibrary.core.ChatBotSDK
import com.chatbotlibrary.model.ChatMessage

@Composable
fun MessageBubble(
    message: ChatMessage
) {

    val config = ChatBotSDK.config

    Row(
        modifier = Modifier.fillMaxWidth(),

        horizontalArrangement =
            if (message.isUser)
                Arrangement.End
            else
                Arrangement.Start
    ) {

        Text(
            text = message.message,

            modifier = Modifier

                .clip(
                    RoundedCornerShape(16.dp)
                )

                .background(
                    if (message.isUser)
                        config.userBubbleColor
                    else
                        config.botBubbleColor
                )

                .padding(14.dp)
        )
    }
}

