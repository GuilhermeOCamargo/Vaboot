package com.gocamargo.vaboot.configuration
import com.natpryce.konfig.*
import com.natpryce.konfig.ConfigurationProperties.Companion.systemProperties
import java.io.File
import java.io.FileInputStream
import java.nio.file.Paths
import java.util.*

/*val telegram_username = Key("telegram.bot.username", stringType)
val telegram_token = Key("telegram.bot.token", stringType)
val my_team_url = Key("page.globoesporte.url", stringType)

val propertiesConfig = systemProperties() overriding
//        EnvironmentVariables() overriding
//        ConfigurationProperties.fromFile(File("/resources/messages.properties")) overriding
        ConfigurationProperties.fromResource("application.properties")*/

object PropertySource{
    private val propertiesConfig = Properties()
    private fun load() = propertiesConfig.load(FileInputStream(File("").absolutePath.plus("/src/main/resources/application.properties")))
    init {
//        println(File("").toPath())
//        println(Paths.get("/resources").toAbsolutePath().toString())
        load()
    }

    fun getProperty(key: String): String = propertiesConfig.getProperty(key)
}
