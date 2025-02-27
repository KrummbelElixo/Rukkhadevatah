package com.rukkhadevatah.app.commands

import com.rukkhadevatah.app.commands.slash.SayCommand
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class CommandManager : ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        val commandData = listOf(
            SayCommand.getCommandData()
        )

        event.jda.updateCommands().addCommands(commandData).queue()
    }
}