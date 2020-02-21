package com.gocamargo.vaboot.service.strategy

import com.gocamargo.vaboot.configuration.MessageSource
import com.gocamargo.vaboot.enums.ApplicationCommands
import com.gocamargo.vaboot.service.CommandService
import com.gocamargo.vaboot.util.ResponseMessage
import com.gocamargo.vaboot.util.parseMessage
import com.gocamargo.vaboot.util.parseMessageCatchinExeption

object HelpCommandStrategy: CommandService{
    override fun handleCommand(requestMessage: String): List<ResponseMessage> {
        val parsedMessage = requestMessage.parseMessageCatchinExeption()

        var response = ApplicationCommands.values()
                .map { applicationCommands -> mutableMapOf("command" to applicationCommands.commandDef,
                        "description" to MessageSource[applicationCommands.softDescription]) }
        return response
    }
}