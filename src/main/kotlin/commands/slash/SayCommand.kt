package com.rukkhadevatah.app.commands.slash

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.CommandData
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.OptionData

class SayCommand : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        if(event.name == "say") {
            val input = event.getOption("input")?.asString ?: throw IllegalStateException()

            event.reply("Feito!")
                .setEphemeral(true)
                .queue()

            event.channel
                .sendMessage(input)
                .queue()
        }
    }


    companion object {
        fun getCommandData(): CommandData {
            return Commands
                .slash("say", "say something!")
                .addOptions(OptionData(OptionType.STRING, "input", "bot will say...?", true))
        }
    }
}