package com.chatbotlibrary.core

object ChatBotSDK {

    lateinit var apiKey: String

    lateinit var baseUrl: String

    var config: ChatBotConfig = ChatBotConfig()

    fun initialize(
        apiKey: String,
        baseUrl: String,
        config: ChatBotConfig = ChatBotConfig()
    ) {

        this.apiKey = apiKey

        this.baseUrl = baseUrl

        this.config = config
    }
}