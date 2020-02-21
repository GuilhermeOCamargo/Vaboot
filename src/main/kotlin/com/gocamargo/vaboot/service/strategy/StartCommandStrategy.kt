package com.gocamargo.vaboot.service.strategy

import com.gocamargo.vaboot.configuration.MessageSource
import com.gocamargo.vaboot.exception.NotYetImplementedException
import com.gocamargo.vaboot.service.CommandService
import com.gocamargo.vaboot.util.ResponseMessage
import com.google.common.collect.Lists
import java.util.*

object StartCommandStrategy: CommandService{

    override fun handleCommand(requestMessage: String): List<ResponseMessage> = listOf(mapOf("message" to MessageSource["bot.start.message"]))
}