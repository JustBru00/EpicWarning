package me.justbru00.epic.warning.Main;

import me.justbru00.epic.warning.GUI.GUIs;
import me.justbru00.epic.warning.JustApi.JustAPI;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EpicWarning extends JavaPlugin {
	
	public final String Prefix = JustAPI.color("&8[&bEpic&4Warning&8] &c");	
	public final ConsoleCommandSender clogger = this.getServer().getConsoleSender();

	@Override
	public boolean onCommand(CommandSender sender, Command command,	String commandLabel, String[] args) {
		
		if (commandLabel.equalsIgnoreCase("warn")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				  if (args.length == 1) {
					  
					  msgPlayer("&aOpening Warning GUI.", player);
					  player.openInventory(GUIs.warninginv(getServer().getPlayer(args[0]), JustAPI.color("&cWarn Inv"), player));
					  
				  } 
				  if (args.length == 0) {
					  msgPlayer("&fPlease put a players name after /warn", player);
				  }
				  if (args.length >= 2) {
					  msgPlayer("Too many args.", player);
				  }
			} msgConsole("You can't warn players from CONSOLE at this time.");
		}
		
		
		return false;
	}

	@Override
	public void onDisable() {
	
	}

	@Override
	public void onEnable() {
		
	}

	
	public void msgConsole(String msg) {
		clogger.sendMessage(Prefix + JustAPI.color(msg));		
	}
	
	public void msgPlayer(String msg, Player player) {
		player.sendMessage(Prefix + JustAPI.color(msg));
	}
}
