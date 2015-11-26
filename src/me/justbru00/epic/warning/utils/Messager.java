package me.justbru00.epic.warning.utils;

import org.bukkit.entity.Player;

import me.justbru00.epic.warning.main.Main;

public class Messager {

	public static void msgConsole(String msg) {
		Main.clogger.sendMessage(Main.Prefix + Main.color(msg));		
	}
	
	public static void msgPlayer(String msg, Player player) {
		player.sendMessage(Main.Prefix + Main.color(msg));
	}	
}
