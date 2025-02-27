package com.rukkhadevatah.app

import com.rukkhadevatah.app.commands.CommandManager
import com.rukkhadevatah.app.commands.slash.SayCommand
import io.github.cdimascio.dotenv.Dotenv
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.OnlineStatus
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import java.util.*

class Application {
    private val dotenv = Dotenv.load()
    private val jda = JDABuilder
        .createLight(dotenv.get("TOKEN"), EnumSet.allOf(GatewayIntent::class.java))
        .setStatus(OnlineStatus.DO_NOT_DISTURB)
        .setActivity(Activity.watching("Test Version"))
        .addEventListeners(
            CommandManager(),
            SayCommand()
        )
        .build()

    companion object {
        fun initialize() {
            Application()
        }
    }
}