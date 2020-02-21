package com.gocamargo.vaboot.enums

import com.gocamargo.vaboot.service.CommandService
import com.gocamargo.vaboot.service.strategy.HelpCommandStrategy
import com.gocamargo.vaboot.service.strategy.MyTeamCommandStrategy
import com.gocamargo.vaboot.service.strategy.StartCommandStrategy

enum class ApplicationCommands (val commandDef: String, val softDescription: String, val service: CommandService ){
    START("/start","command.start.description", StartCommandStrategy),
    MYTEAM("/myteam","command.myteam.description", MyTeamCommandStrategy),
    HELP("/help", "command.help.description", HelpCommandStrategy);

    companion object{
        @JvmStatic
        fun fromMessage(command: String): ApplicationCommands =
                values().first { v -> v.commandDef == command }
    }
}