package com.rukkhadevatah.app

import io.github.cdimascio.dotenv.Dotenv
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.requests.GatewayIntent
import java.util.*

object Main {
    private val dotenv = Dotenv.load()
    private val jda = JDABuilder
        .createLight(dotenv.get("TOKEN"), EnumSet.allOf(GatewayIntent::class.java))
        .setActivity(Activity.watching("Test Version"))

    @JvmStatic
    fun main(args: Array<String>) {
        
    }
}