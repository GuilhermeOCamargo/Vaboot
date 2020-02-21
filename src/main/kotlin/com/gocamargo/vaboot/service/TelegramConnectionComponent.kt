package com.gocamargo.vaboot.service

import com.gocamargo.vaboot.configuration.PropertySource
import com.gocamargo.vaboot.enums.ApplicationCommands
import com.gocamargo.vaboot.util.ResponseMessage
import com.gocamargo.vaboot.util.cast
import com.gocamargo.vaboot.util.runCathingException
import com.gocamargo.vaboot.util.toMessageResponse
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class TelegramConnectionComponent: TelegramLongPollingBot(){

    private val telegramToken = PropertySource["telegram.bot.token"]
    private val telegramUsername = PropertySource["telegram.bot.username"]

    override fun getBotUsername(): String = telegramUsername!!

    override fun getBotToken(): String = telegramToken!!

    override fun onUpdateReceived(update: Update?) {
        if(update!!.hasMessage()){
            runCathingException({ handleMessage(update.message.text) }){  listOf(mapOf("message" to it.message)) }!!
                    .cast<List<ResponseMessage>>()
                    .map { response -> sendResponse(response.toMessageResponse(), update.message.chatId) }
            /*runCathingException() { handleMessage(update.message.text) }
                    .map{response -> sendResponse(response.toMessageResponse(), update.message.chatId)  }*/

        }
    }

    private fun sendResponse(message: String?, chatId: Long) {
        var responseMessage = SendMessage().setChatId(chatId)
        responseMessage.text = message
        execute(responseMessage)
    }

    private fun handleMessage(message: String): List<ResponseMessage> =
            ApplicationCommands.fromMessage(parseMessage(message)).service.handleCommand(message)

    private fun parseMessage(message: String): String =
            if(message.indexOf(" ")>0)
                message.substring(0, message.indexOf(" ")).trim()
            else
                message
}