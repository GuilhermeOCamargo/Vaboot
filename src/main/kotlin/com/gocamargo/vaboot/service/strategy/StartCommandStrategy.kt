package com.gocamargo.vaboot.service.strategy

import com.gocamargo.vaboot.exception.NotYetImplementedException
import com.gocamargo.vaboot.service.CommandService
import com.gocamargo.vaboot.util.ResponseMessage

object StartCommandStrategy: CommandService{

    override fun handleCommand(requestMessage: String): ResponseMessage {
        throw NotYetImplementedException("Não implementado")
    }
}