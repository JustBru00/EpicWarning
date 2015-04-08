package me.justbru00.epic.warning.GUI;

import me.justbru00.epic.warning.JustApi.JustAPI;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUIs {

	public static Inventory warninginv(Player warnedplayer, String name, Player sentbyplayer) {
		Inventory inv = JustAPI.createInv(name,	54);
		
		inv.setItem(4, JustAPI.createSkullwithLore("&4" + warnedplayer.getName(), warnedplayer.getName(), "&cThis User is Being Warned"));
    	inv.setItem(3, JustAPI.createItem("&b" + sentbyplayer.getName(), Material.PAPER, "&fYou are: " + sentbyplayer.getName()));
    	inv.setItem(5, JustAPI.createItem("&fPlugin made by:", Material.PAPER, "&bJustBru00"));
    	
	
		
		return inv;
	}
	
}


