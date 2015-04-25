package me.justbru00.epic.warning.Main;

import me.justbru00.epic.warning.GUI.GUIs;
import me.justbru00.epic.warning.JustApi.API;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class EpicWarning extends JavaPlugin {
	
	public final String Prefix = API.color("&8[&bEpic&4Warning&8] &c");	
	public final ConsoleCommandSender clogger = this.getServer().getConsoleSender();
	public final FileConfiguration config = getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command command,	String commandLabel, String[] args) {
		
		if (commandLabel.equalsIgnoreCase("warn")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				  if (args.length == 1) {					  
					  msgPlayer("&aOpening Warning GUI.", player);
					  player.openInventory(GUIs.warninginv(getServer().getPlayer(args[0]), API.color("&cWarn Inv"), player));
					  
					  return true;
				  } 
				  if (args.length == 0) {
					  msgPlayer("&fPlease put a players name after /warn", player);
					  return true;
				  }
				  if (args.length >= 2) {
					  msgPlayer("Too many args.", player);
					  return true;
				  }
			} msgConsole("You can't warn players from CONSOLE at this time.");
		}
		
		
		return true;
	}

	@Override
	public void onDisable() {
	
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		if (enableConfiguration()) {
			msgConsole("&fSaved Default Config.");
		} else {
			msgConsole("&cError saving default config. (Try deleting your current one and restarting the server.)");
		}
		
		clogger.sendMessage(Prefix + ChatColor.GOLD + "Version: " + pdfFile.getVersion() + " Has Been Enabled.");
	}
	
	public boolean enableConfiguration() {
		this.saveDefaultConfig();
		return true;     
	}
	
	public String getConfigString(String location){		
		return config.getString(location);
	}
	
	public void msgConsole(String msg) {
		clogger.sendMessage(Prefix + API.color(msg));		
	}
	
	public void msgPlayer(String msg, Player player) {
		player.sendMessage(Prefix + API.color(msg));
	}
}
