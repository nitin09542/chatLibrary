package com.chatbotlibrary.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chatbotlibrary.core.ChatBotSDK

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatBotScreen(

    modifier: Modifier = Modifier,

    onBackClick: (() -> Unit)? = null
) {

    val viewModel: ChatViewModel = viewModel()

    val config = ChatBotSDK.config

    var text by remember {
        mutableStateOf("")
    }

    val listState = rememberLazyListState()

    LaunchedEffect(viewModel.messages.size) {

        if (viewModel.messages.isNotEmpty()) {

            listState.animateScrollToItem(
                viewModel.messages.lastIndex
            )
        }
    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {
                    Text(config.botName)
                }
            )
        }

    ) { padding ->

        Column(

            modifier = modifier
                .fillMaxSize()
                .padding(padding)
                .imePadding()
        ) {

            LazyColumn(

                state = listState,

                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp),

                verticalArrangement =
                    Arrangement.spacedBy(8.dp)
            ) {

                items(viewModel.messages) {

                    MessageBubble(it)
                }
            }

            if (
                viewModel.isTyping &&
                config.enableTypingIndicator
            ) {

                TypingIndicator()
            }

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {

                OutlinedTextField(

                    value = text,

                    onValueChange = {
                        text = it
                    },

                    modifier = Modifier.weight(1f)
                )

                Button(

                    onClick = {

                        if (text.isNotBlank()) {

                            viewModel.sendMessage(text)

                            text = ""
                        }
                    }

                ) {

                    Icon(
                        Icons.Default.Send,
                        contentDescription = null
                    )
                }
            }
        }
    }
}