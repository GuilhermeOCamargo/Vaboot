package com.gocamargo.vaboot.service

import com.gocamargo.vaboot.component.propertiesConfig
import com.gocamargo.vaboot.component.*
import com.gocamargo.vaboot.enums.ApplicationCommands
import com.gocamargo.vaboot.util.ResponseMessage
import com.gocamargo.vaboot.util.toMessageResponse
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class TelegramConnectionComponent: TelegramLongPollingBot(){

    private val telegramToken = propertiesConfig[telegram_token]
    private val telegramUsername = propertiesConfig[telegram_username]

    override fun getBotUsername(): String = telegramUsername!!

    override fun getBotToken(): String = telegramToken!!

    override fun onUpdateReceived(update: Update?) {
        if(update!!.hasMessage()){
            var responseMessage = SendMessage().setChatId(update.message.chatId)
            responseMessage.text = handleMessage(update.message.text).toMessageResponse()
        }
    }


    private fun handleMessage(message: String): ResponseMessage =
            ApplicationCommands.fromMessage(parseMessage(message)).service.handleCommand(message)

    private fun parseMessage(message: String): String =
            if(message.indexOf(" ")>0)
                message.substring(0, message.indexOf(" ")).trim()
            else
                message
}