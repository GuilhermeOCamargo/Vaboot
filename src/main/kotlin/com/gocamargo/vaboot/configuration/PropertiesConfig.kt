package com.gocamargo.vaboot.configuration
import java.io.File
import java.io.FileInputStream
import java.util.*

sealed class LoadPropertiesUtil (private val fileName: String){
    private val propertiesConfig = Properties()
    private fun load() = propertiesConfig.load(FileInputStream(File("").absolutePath.plus("/src/main/resources/$fileName")))
    init {
        load()
    }
    operator fun get(key: String): String = propertiesConfig.getProperty(key)
}

object PropertySource: LoadPropertiesUtil("application.properties")
object MessageSource: LoadPropertiesUtil("messages.properties")