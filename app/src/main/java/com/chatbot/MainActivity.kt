package com.chatbot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chatbot.ui.theme.ChatBotTheme
import com.chatbotlibrary.chatSupport.data.ui.ChatScreenSupport
import com.chatbotlibrary.core.ChatBotConfig
import com.chatbotlibrary.core.ChatBotSDK
import com.chatbotlibrary.presentation.ChatBotScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ChatBotSDK.initialize(

            apiKey = "",
            baseUrl="",

            config = ChatBotConfig(

                primaryColor = Color.Blue,

                botName = "Nitin AI"
            )
        )


        setContent {
            ChatBotTheme{

              //  ChatBotScreen()

                ChatScreenSupport()


            }
        }
        }
    }



