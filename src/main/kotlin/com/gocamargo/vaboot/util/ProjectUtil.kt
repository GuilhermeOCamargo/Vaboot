package com.gocamargo.vaboo.util

import java.util.*

typealias ResponseMessage = Map<String, Any?>
fun <T> getProp(key: String): T {
    val props  = javaClass.classLoader.getResourceAsStream("pairs_ids.txt").use {
        Properties().apply { load(it) }
    }
    return (props.getProperty(key) as T) ?: throw RuntimeException("could not find property $key")
}