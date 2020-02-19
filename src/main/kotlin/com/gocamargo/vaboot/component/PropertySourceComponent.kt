package com.gocamargo.vaboo.configuration
import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties
import java.io.File

val telegram_username = Key("telegram.bot.username", stringType)
val telegram_token = Key("telegram.bot.token", stringType)
val my_team_url = Key("page.globoesporte.url", stringType)

val propertiesConfig = systemProperties() overriding
        EnvironmentVariables() overriding
        ConfigurationProperties.fromFile(File("/resources/")) overriding
        ConfigurationProperties.fromResource("application.properties")