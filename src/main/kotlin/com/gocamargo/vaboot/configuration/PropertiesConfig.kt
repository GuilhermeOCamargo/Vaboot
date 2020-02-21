package com.gocamargo.vaboot.configuration
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.util.*

sealed class LoadPropertiesUtil (private val fileName: String){
    private val propertiesConfig = Properties()
    private val input = FileInputStream(File("").absolutePath.plus("/src/main/resources/$fileName"))
    private fun load() = propertiesConfig.load(InputStreamReader(input, Charset.forName("UTF-8")))
    init {
        load()
    }
    operator fun get(key: String): String = propertiesConfig.getProperty(key).format(Locale.forLanguageTag("UTF-8"))
}

object PropertySource: LoadPropertiesUtil("application.properties")
object MessageSource: LoadPropertiesUtil("messages.properties")