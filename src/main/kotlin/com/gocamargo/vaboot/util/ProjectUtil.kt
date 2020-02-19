package com.gocamargo.vaboot.util

typealias ResponseMessage = Map<String, Any?>

inline fun ResponseMessage?.toMessageResponse(): String? =
    if(!this.isNullOrEmpty())
        "OK"
    else
        null

inline fun <T> T?.isNull(): Boolean = this == null