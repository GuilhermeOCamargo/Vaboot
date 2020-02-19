package com.gocamargo.vaboo.enums

import com.gocamargo.vaboo.service.CommandService
import com.gocamargo.vaboo.service.strategy.MyTeamCommandStrategy
import com.gocamargo.vaboo.service.strategy.StartCommandStrategy

enum class ApplicationCommands (private val commandDef: String, val service: CommandService ){
    START("/start", StartCommandStrategy.instance),
    MYTEAM("/myteam", MyTeamCommandStrategy.instance);

    companion object{
        @JvmStatic
        fun fromMessage(command: String): ApplicationCommands =
                values().first { v -> v.commandDef == command }
    }
}