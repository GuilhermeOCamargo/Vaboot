package com.gocamargo.vaboo.service

import com.gocamargo.vaboo.configuration.propertiesConfig
import com.gocamargo.vaboo.configuration.*
import com.gocamargo.vaboo.enums.ApplicationCommands
import com.gocamargo.vaboo.util.ResponseMessage
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class TelegramConnectionComponent: TelegramLongPollingBot(){

    private val telegramToken = propertiesConfig[telegram_token]
    private val telegramUsername = propertiesConfig[telegram_username]

    override fun getBotUsername(): String = telegramUsername!!

    override fun getBotToken(): String = telegramToken!!

    override fun onUpdateReceived(update: Update?) {
        if(update!!.hasMessage())
            val responseMessage = SendMessage().setChatId(update.message.chatId)
            handleMessage(update.message.text)
                    .map {  }
    }


    private fun handleMessage(message: String): ResponseMessage =
            ApplicationCommands.fromMessage(parseMessage(message)).service.handleCommand(message)

    private fun parseMessage(message: String): String =
            if(message.indexOf(" ")>0)
                message.substring(0, message.indexOf(" ")).trim()
            else
                message
}