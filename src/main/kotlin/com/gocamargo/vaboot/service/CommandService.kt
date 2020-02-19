package com.gocamargo.vaboo.service

import com.gocamargo.vaboo.util.ResponseMessage

interface CommandService {
    fun handleCommand(requestMessage: String): ResponseMessage
}