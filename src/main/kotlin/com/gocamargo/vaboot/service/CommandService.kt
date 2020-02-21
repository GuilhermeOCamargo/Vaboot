package com.gocamargo.vaboot.service

import com.gocamargo.vaboot.util.ResponseMessage

interface CommandService {
    fun handleCommand(requestMessage: String): List<ResponseMessage>
}