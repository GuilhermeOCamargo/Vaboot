package com.gocamargo.vaboot.service.strategy

import com.gocamargo.vaboot.configuration.MessageSource
import com.gocamargo.vaboot.enums.ApplicationCommands
import com.gocamargo.vaboot.service.CommandService
import com.gocamargo.vaboot.util.ResponseMessage
import com.gocamargo.vaboot.util.parseMessageCatchinExeption

object HelpCommandStrategy: CommandService{
    override fun handleCommand(requestMessage: String): List<ResponseMessage> {
        val parsedMessage = requestMessage.parseMessageCatchinExeption(){null}
        lateinit var response: List<ResponseMessage>
        if(parsedMessage.isNullOrEmpty()){
            response = ApplicationCommands.values()
                    .map { applicationCommands -> createMessage(applicationCommands) }
        }else{
            response = listOf(createMessage(ApplicationCommands.fromMessage(parsedMessage)))
        }

        return response
    }

    private fun createMessage(applicationCommand: ApplicationCommands): ResponseMessage =
            mapOf("command" to applicationCommand.commandDef,
                    "description" to MessageSource[applicationCommand.softDescription])
}