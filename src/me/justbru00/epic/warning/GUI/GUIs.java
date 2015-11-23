/**
 * THE (“EpicWarning”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY.
 * ANY COMMERCIAL DISTRIBUTION/USE OF THE (“EpicWarning”) SOURCE IS STRICTLY PROHIBITED.
 */
package me.justbru00.epic.warning.GUI;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import me.justbru00.epic.warning.main.Main;
import me.justbru00.epic.warning.utils.ItemMaker;

public class GUIs {
	
	
	
	public static Inventory punishingGUI(Player target, Main main) {
		Inventory inv = Bukkit.createInventory(null, 54, Main.color("&cPunishing: " + target.getName()));
		
		inv.setItem(10, ItemMaker.createItem("STAINED_CLAY", "&eSeverity 1", (short) 4));
		
		return inv;
	}
}
