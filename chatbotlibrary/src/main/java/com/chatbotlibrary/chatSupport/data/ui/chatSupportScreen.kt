package com.chatbotlibrary.chatSupport.data.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chatbotlibrary.chatSupport.data.ChatMessage

@Composable
fun ChatScreenSupport(
    viewModel: ChatViewModel = viewModel()
) {

    val messages = viewModel.messages

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(messages) { message ->

                when(message) {

                    is ChatMessage.TextMessage -> {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement =
                                if(message.isBot)
                                    Arrangement.Start
                                else
                                    Arrangement.End
                        ) {

                            Card {

                                Text(
                                    text = message.message,
                                    modifier = Modifier.padding(12.dp)
                                )
                            }
                        }
                    }

                    is ChatMessage.OptionMessage -> {

                        Column {

                            Text(
                                text = message.title,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Column(
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {

                                message.options.forEach { option ->

                                    Button(
                                        onClick = {
                                            viewModel.onOptionSelected(option)
                                        }
                                    ) {
                                        Text(option)
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}