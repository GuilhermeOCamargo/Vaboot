package com.gocamargo.vaboot.service.strategy

import com.gocamargo.vaboot.configuration.MessageSource
import com.gocamargo.vaboot.configuration.PropertySource
import com.gocamargo.vaboot.service.CommandService
import com.gocamargo.vaboot.util.ResponseMessage
import com.gocamargo.vaboot.util.parseMessage
import com.gocamargo.vaboot.util.searchElementsInPage
import org.jsoup.nodes.Element

object CurrencyCommandStrategy: CommandService{
    override fun handleCommand(requestMessage: String): List<ResponseMessage> {
        val parsedMessage = requestMessage.parseMessage()
        check(!parsedMessage.isNullOrEmpty()){ MessageSource["exception.parse.message"]}
        return searchElementsInPage(PropertySource["page.currency.url"].plus("$parsedMessage-hoje"), "row")
                .map { element -> createMap(element) }
    }

    private fun createMap(element: Element) :ResponseMessage =
            mapOf("message" to (element.getElementById("comercial").text() ?: null))
}