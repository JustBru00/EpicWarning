package me.justbru00.epic.warning.Main;

import me.justbru00.epic.warning.GUI.GUIs;
import me.justbru00.epic.warning.JustApi.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public class EpicWarning extends JavaPlugin implements Listener{
	
	public final String Prefix = API.color("&8[&bEpic&4Warning&8] &c");	
	public final ConsoleCommandSender clogger = this.getServer().getConsoleSender();
	public final FileConfiguration config = getConfig();	
	public Boolean guiinuse = false;
	public Player warningplayer;
	public Player guiopener;
	public int maxPoints;

	
	@Override
	public boolean onCommand(CommandSender sender, Command command,	String commandLabel, String[] args) {
		
		if (commandLabel.equalsIgnoreCase("warn")) {
			if (sender instanceof Player) {
				Player player = (Player) sender;
				  if (args.length == 1) {
					  if (!guiinuse) {
					  msgPlayer("&aOpening Warning GUI.", player);
					  Player targetplayer = getServer().getPlayer(args[0]);					  
					  player.openInventory(warninginv(targetplayer, API.color("&cWarn Inv"), player));
					  
					  return true;
					  } else {
						  msgPlayer("&cSorry the warning GUI is already in use.", player);
					  }
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
		
		
		return false;
	}

	@Override
	public void onDisable() {
	
	}

	@Override
	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		getServer().getPluginManager().registerEvents(this, this);
		
			if (enableConfiguration()) {
			msgConsole("&fSaved Default Config.");
		} else {
			msgConsole("&cError saving default config. (Try deleting your current one and restarting the server.)");
		}
		maxPoints = config.getInt("warning options.options.max points");
				clogger.sendMessage(Prefix + ChatColor.GOLD + "Version: " + pdfFile.getVersion() + " Has Been Enabled.");
	}
	
	public boolean enableConfiguration() {
		this.saveDefaultConfig();
		return true;     
	}
	
	public String getConfigString(String location){		
		return config.getString(location);
	}
	
	public void writeInttoConfig(String path, int Int) {
		config.set(path, Int);
		saveConfig();
	}
	
	public void msgConsole(String msg) {
		clogger.sendMessage(Prefix + API.color(msg));		
	}
	
	public void msgPlayer(String msg, Player player) {
		player.sendMessage(Prefix + API.color(msg));
	}	
	
	public void writeWarningpoints(int slot) {
		if (config.isSet("warning points." + warningplayer.getUniqueId() + ".points")) {
		int points = config.getInt("warning points." + warningplayer.getUniqueId() + ".points");
		  if (points < maxPoints) {
		   if (slot == 18) {
			   if (getConfigString("warning options.options.one").equals("ADD")) {
				   	points = points + 1;
				   	config.set("warning points." + warningplayer.getUniqueId() + ".points", points);
				   	saveConfig();
			   }
			   msgPlayer("&6You were warned for " + getConfigString("gui.third row.displaynames.one") + " &6.", warningplayer);
		   }
		  } else {			  
			  warningplayer.kickPlayer(API.color("&cYou have gone above max warning points!"));	
			  Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "ban " + warningplayer.getName() + " Going above max warning points!");
			  }
		} else {
			config.set("warning points." + warningplayer.getUniqueId() + ".points", 0);
			saveConfig();
			return;
			} 
		
	}
	
	@EventHandler
	public void InventoryCloseEvent(InventoryCloseEvent e) {
		Player p = (Player) e.getPlayer();
		if (e.getInventory().getTitle().contains(API.color("&cWarn Inv"))) {
			guiinuse = false;
		}
	}
	@EventHandler
	public void InventoryClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getInventory().getTitle().contains(API.color("&cWarn Inv"))) {
			e.setCancelled(true);

			if (e.getCurrentItem() == null) {
				return;
			}			
				if (e.getSlot() == 18){
					
					writeWarningpoints(18);
					p.closeInventory();
					msgPlayer(API.color("&6You just warned &c" + warningplayer + " &6for &c" + getConfigString("gui.third row.displaynames.one") + " &6."), p);
				}
				if (e.getSlot() == 1) {
					p.closeInventory();
				
				}
				if (e.getSlot() == 2) {
					p.closeInventory();
				}
				if (e.getSlot() == 3){
					p.closeInventory();
				}
				if (e.getSlot() == 4){
					p.closeInventory();
				}					
		}

	}
	
	public Inventory warninginv(Player warnedplayer, String name, Player sentbyplayer) {
		guiinuse = true;
		guiopener = sentbyplayer;
		warningplayer = warnedplayer;
		Inventory inv = API.createInv(name,	54);
		
		inv.setItem(4, API.createSkullwithLore("&4" + warnedplayer.getName(), warnedplayer.getName(), "&cThis User is Being Warned"));
    	inv.setItem(3, API.createItem("&b" + sentbyplayer.getName(), Material.PAPER, "&fYou are: " + sentbyplayer.getName()));
    	inv.setItem(5, API.createItem("&fPlugin made by:", Material.PAPER, "&bJustBru00"));
    	inv.setItem(18, API.createItem(API.color(getConfigString("gui.third row.displaynames.one")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.one"))));
    	inv.setItem(20, API.createItem(API.color(getConfigString("gui.third row.displaynames.two")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.two"))));	
    	inv.setItem(22, API.createItem(API.color(getConfigString("gui.third row.displaynames.three")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.three"))));
    	inv.setItem(24, API.createItem(API.color(getConfigString("gui.third row.displaynames.four")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.four"))));
    	inv.setItem(26, API.createItem(API.color(getConfigString("gui.third row.displaynames.five")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.five"))));
    	inv.setItem(27, API.createItem(API.color(getConfigString("gui.fourth row.displaynames.one")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.six"))));
    	inv.setItem(29, API.createItem(API.color(getConfigString("gui.fourth row.displaynames.two")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.seven"))));
    	inv.setItem(31, API.createItem(API.color(getConfigString("gui.fourth row.displaynames.three")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.eight"))));
    	inv.setItem(33, API.createItem(API.color(getConfigString("gui.fourth row.displaynames.four")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.nine"))));
    	inv.setItem(35, API.createItem(API.color(getConfigString("gui.fourth row.displaynames.five")), Material.PAPER, API.color("&cAction: " + getConfigString("warning options.options.ten"))));
		return inv;
	}
	/**
	 *  0  1  2  .3  .4  .5  6  7  8
	 *  9 10 11 12 13 14 15 16 17
	 * .18 19 .20 21 .22 23 .24 25 .26
	 * .27 28 .29 30 .31 32 .33 34 .35
	 * .36 37 .38 39 .40 41 .42 43 .44
	 * .45 46 .47 48 .49 50 .51 52 .53
	 * 
	 * 3 = Sent by player's name
	 * 4 = Player being warned
	 * 5 = Made by JustBru00
	 * 18 = Warning option 1 
	 * 20 = Warning option 2
	 * 22 = Warning option 3
	 * 24 = Warning option 4
	 * 26 = Warning option 5
	 * 27 = Warning option 6
	 * 29 = Warning option 7
	 * 31 = Warning option 8
	 * 3
	 * 
	 *
	 */
}
