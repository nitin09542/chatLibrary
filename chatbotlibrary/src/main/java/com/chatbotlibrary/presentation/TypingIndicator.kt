package com.chatbotlibrary.presentation


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TypingIndicator() {

    Row(
        modifier = Modifier.padding(12.dp)
    ) {

        CircularProgressIndicator()

        Text(
            text = " Bot is typing...",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

