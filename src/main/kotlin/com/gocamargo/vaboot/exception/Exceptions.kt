package com.gocamargo.vaboot.exception

import java.lang.RuntimeException

class MessageParseException constructor(message: String) : RuntimeException(message)

class NotYetImplementedException constructor(message: String): RuntimeException(message)

class ValidationException constructor(message: String): RuntimeException(message)