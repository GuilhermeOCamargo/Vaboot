package com.gocamargo.vaboot.util

import com.gocamargo.vaboot.configuration.MessageSource
import com.gocamargo.vaboot.exception.MessageParseException
import org.jsoup.nodes.Element
import javax.xml.bind.ValidationException

typealias ResponseMessage = Map<String, Any?>

inline fun ResponseMessage?.toMessageResponse(): String?{
    if(!this.isNullOrEmpty()){
        var message = ""
        this.keys
                .forEach { key -> message = message.plus("${this!![key]} \n")}
        return message
    }
    else
        return null
}

inline fun runCathingException(block: () -> List<ResponseMessage>?): List<ResponseMessage> =
        try{
            block()!!
        } catch (exception: Throwable){
            println(exception.cause)
            listOf(mapOf("message" to exception.message))
        }

inline fun Element?.filterElementByClass(className: String): Boolean =
        this!=null && !this.getElementsByClass(className).isNullOrEmpty()

fun String.parseMessage(): String =
        try{
            this.substring(this.indexOf(" ")).trim()
        }catch (exception: StringIndexOutOfBoundsException){
            throw MessageParseException(MessageSource["exception.parse.message"], exception)
        }