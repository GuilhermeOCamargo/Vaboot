package com.gocamargo.vaboot

import com.gocamargo.vaboot.service.TelegramConnectionComponent
import org.telegram.telegrambots.ApiContextInitializer
import org.telegram.telegrambots.meta.TelegramBotsApi

fun main(args: Array<String>) {

    ApiContextInitializer.init()

    TelegramBotsApi().registerBot(TelegramConnectionComponent())


}
