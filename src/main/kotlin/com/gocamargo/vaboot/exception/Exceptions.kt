package com.gocamargo.vaboot.exception


class MessageParseException constructor(message: String, cause: Throwable?) : Throwable(message, cause)

class NotYetImplementedException constructor(message: String, cause: Throwable?): Throwable(message, cause)

class ValidationException constructor(message: String, cause: Throwable): Throwable(message, cause)