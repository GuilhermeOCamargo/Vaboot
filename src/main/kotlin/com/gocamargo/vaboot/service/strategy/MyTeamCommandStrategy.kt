package com.gocamargo.vaboot.service.strategy

import com.gocamargo.vaboot.configuration.MessageSource
import com.gocamargo.vaboot.configuration.PropertySource
import com.gocamargo.vaboot.exception.MessageParseException
import com.gocamargo.vaboot.exception.NotYetImplementedException
import com.gocamargo.vaboot.service.CommandService
import com.gocamargo.vaboot.util.ResponseMessage
import com.gocamargo.vaboot.util.filterElementByClass
import com.gocamargo.vaboot.util.parseMessage
import com.gocamargo.vaboot.util.searchElementsInPage
import org.jsoup.nodes.Element

object MyTeamCommandStrategy : CommandService {

    override fun handleCommand(requestMessage: String): List<ResponseMessage> {
        val parsedMessage = requestMessage.parseMessage()
        check(!parsedMessage.isNullOrEmpty()){MessageSource["exception.parse.message"]}
        return searchElementsInPage(PropertySource["page.globoesporte.url"].plus(parsedMessage), "bastian-feed-item")
                .filter { element ->  element.filterElementByClass("feed-post-body-resumo")}
                .map { element -> createMap(element) }
    }

    private fun createMap(element: Element) :ResponseMessage =
            mapOf("title" to (element.getElementsByClass("feed-post-link").first().text() ?: null),
                "summary" to (element.getElementsByClass("feed-post-body-resumo").first().getElementsByClass("_label_event").text() ?: null),
                "link" to (element.getElementsByClass("feed-post-link").first().attr("href") ?: null))


}