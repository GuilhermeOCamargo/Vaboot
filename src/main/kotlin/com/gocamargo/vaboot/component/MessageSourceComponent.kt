package com.gocamargo.vaboo.component
import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties
import java.io.File

val telegramUsername = Key("telegram.bot.username", stringType)
val telegramToken = Key("telegram.bot.token", stringType)
val myTeamUrl = Key("page.globoesporte.url", stringType)

val config = systemProperties() overriding
        EnvironmentVariables() overriding
        ConfigurationProperties.fromFile(File("/resources/")) overriding
        ConfigurationProperties.fromResource("application.properties")

