package com.gocamargo.vaboo.service.strategy

import com.gocamargo.vaboo.exception.NotYetImplementedException
import com.gocamargo.vaboo.service.CommandService
import com.gocamargo.vaboo.util.ResponseMessage

class StartCommandStrategy : CommandService {
    companion object{
        val instance = StartCommandStrategy()
    }
    override fun handleCommand(requestMessage: String): ResponseMessage {
        throw NotYetImplementedException("Não implementado")
    }
}