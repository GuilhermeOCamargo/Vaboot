package com.gocamargo.vaboot.exception


class MessageParseException constructor(message: String) : Throwable(message)

class NotYetImplementedException constructor(message: String): Throwable(message)

class ValidationException constructor(message: String): Throwable(message)