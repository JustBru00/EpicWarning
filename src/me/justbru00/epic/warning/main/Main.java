/**
 * THE (“EpicWarning”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY.
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“EpicWarning”) SOURCE IS STRICTLY PROHIBITED.
 */
package me.justbru00.epic.warning.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.warren1001.configapi.Config;
import me.justbru00.epic.warning.Listeners.ClickWatcher;
import me.justbru00.epic.warning.Listeners.JoinWatcher;
import me.justbru00.epic.warning.commands.Punish;
import me.justbru00.epic.warning.utils.Messager;


public class Main extends JavaPlugin implements Listener{
	
	public static String Prefix = color("&8[&bEpic&4Warning&8] &c");	
	public static ConsoleCommandSender clogger = Bukkit.getServer().getConsoleSender();	
	public Config points = new Config(this, "points.yml");
	
	
	@Override
	public void onDisable() {
		Messager.msgConsole("Plugin disabled.");
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

	
	public static String color(String uncolored) {
		return ChatColor.translateAlternateColorCodes('&', uncolored);
	}
}
