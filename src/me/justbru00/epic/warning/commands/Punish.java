/**
 * THE (“EpicWarning”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY.
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“EpicWarning”) SOURCE IS STRICTLY PROHIBITED.
 */
package me.justbru00.epic.warning.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.justbru00.epic.warning.GUI.GUIs;
import me.justbru00.epic.warning.main.Main;

public class Punish implements CommandExecutor {
	
	Main main;
	
	public Punish(Main main) {
		this.main = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,	String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("punish")) {
			if (sender instanceof Player) {
				Player playerSender = (Player) sender;
				  if (args.length == 1) {
					  Player target;
					  
					  	try {
					  		target = Bukkit.getPlayer(args[0]);
					  	} catch (Exception e) {
					  		Main.msgPlayer("&cThat player can't be found.", playerSender);
					  		return true;
					  	}		  
					
					  
					  playerSender.openInventory(GUIs.punishingGUI(target, main));	
					  
					  return true;					
				  } 
				  if (args.length == 0) {
					  Main.msgPlayer("&fPlease put a players name after /warn", playerSender);
					  return true;
				  }
				  if (args.length >= 2) {
					  Main.msgPlayer("Too many args.", playerSender);
					  return true;
				  }
			} Main.msgConsole("You can't warn players from CONSOLE at this time.");
		}
		
		
		return false;

	}

}
