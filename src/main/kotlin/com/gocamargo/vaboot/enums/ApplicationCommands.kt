package com.gocamargo.vaboot.enums

import com.gocamargo.vaboot.service.CommandService
import com.gocamargo.vaboot.service.strategy.MyTeamCommandStrategy
import com.gocamargo.vaboot.service.strategy.StartCommandStrategy

enum class ApplicationCommands (private val commandDef: String, val service: CommandService ){
    START("/start", StartCommandStrategy),
    MYTEAM("/myteam", MyTeamCommandStrategy);

    companion object{
        @JvmStatic
        fun fromMessage(command: String): ApplicationCommands =
                values().first { v -> v.commandDef == command }
    }
}