/**
 * THE (“EpicWarning”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY.
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“EpicWarning”) SOURCE IS STRICTLY PROHIBITED.
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
		
		
		// Row 2
		inv.setItem(9, ItemMaker.createItem("STAINED_CLAY", "&eSeverity 1", (short) 4));
		inv.setItem(10, ItemMaker.createItem("SIGN", "&fCaps", ItemMaker.NO_DATA_VALUE));
		inv.setItem(11, ItemMaker.createItem("SIGN", "&fSpam", ItemMaker.NO_DATA_VALUE));
		inv.setItem(12, ItemMaker.createItem("SIGN", "&fGeneral Rudeness", ItemMaker.NO_DATA_VALUE));
		inv.setItem(13, ItemMaker.createItem("SIGN", "&fHackusation", ItemMaker.NO_DATA_VALUE));
		inv.setItem(14, ItemMaker.createItem("SIGN", "&fArguing", ItemMaker.NO_DATA_VALUE));
		inv.setItem(15, ItemMaker.createItem("SIGN", "&fChat Trolling", ItemMaker.NO_DATA_VALUE));
		inv.setItem(16, ItemMaker.createItem("SIGN", "&fMini-Modding", ItemMaker.NO_DATA_VALUE));
		inv.setItem(17, ItemMaker.createItem("SIGN", "&fLight Advertisement", ItemMaker.NO_DATA_VALUE));
		
		return inv;
	}
}

/**
 *   0  1  2  3  4  5  6  7  8 // Info Stuff
 *   9 10 11 12 13 14 15 16 17 // Severity one offences
 *  18 19 20 21 22 23 24 25 26 // Severity two offences  
 *  27 28 29 30 31 32 33 34 35 // Severity three offences
 *  36 37 38 39 40 41 42 43 44 // Severity four offences
 *  45 46 47 48 49 50 51 52 53
 *  
 * 
 * 
 */
