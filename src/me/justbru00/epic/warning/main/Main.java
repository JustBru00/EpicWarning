/**
 *     EpicPunish a minecraft plugin that adds helpful punishing commands.
    Copyright (C) 2015  Justin A. Brubaker

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

	Contact me at: justbru00@gmail.com
 */
package me.justbru00.epic.warning.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.warren1001.configapi.Config;
import me.justbru00.epic.warning.Listeners.ClickWatcher;
import me.justbru00.epic.warning.Listeners.JoinWatcher;
import me.justbru00.epic.warning.commands.Punish;


public class Main extends JavaPlugin implements Listener{
	
	public static String Prefix = color("&8[&bEpic&4Warning&8] &c");	
	public static ConsoleCommandSender clogger = Bukkit.getServer().getConsoleSender();	
	public Config points = new Config(this, "points.yml");
	
	
	@Override
	public void onDisable() {
		msgConsole("Plugin disabled.");
	}

	@Override
	public void onEnable() {		
		this.saveDefaultConfig();
		getServer().getPluginManager().registerEvents(new ClickWatcher(this), this);	
		getServer().getPluginManager().registerEvents(new JoinWatcher(this), this);
		
		getCommand("punish").setExecutor(new Punish(this));
		
	}
	public boolean enableConfiguration() {
		this.saveDefaultConfig();
		return true;     
	}
	
	public String getConfigString(String location){		
		return getConfig().getString(location);
	}	
	
	public static void msgConsole(String msg) {
		clogger.sendMessage(Prefix + color(msg));		
	}
	
	public static void msgPlayer(String msg, Player player) {
		player.sendMessage(Prefix + color(msg));
	}	
	
	public static String color(String uncolored) {
		return ChatColor.translateAlternateColorCodes('&', uncolored);
	}
}
