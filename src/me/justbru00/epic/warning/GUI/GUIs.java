package me.justbru00.epic.warning.GUI;

import me.justbru00.epic.warning.JustApi.API;
import me.justbru00.epic.warning.Main.EpicWarning;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GUIs {
	
	private static EpicWarning main = new EpicWarning();

	public static Inventory warninginv(Player warnedplayer, String name, Player sentbyplayer) {
		Inventory inv = API.createInv(name,	54);
		
		inv.setItem(4, API.createSkullwithLore("&4" + warnedplayer.getName(), warnedplayer.getName(), "&cThis User is Being Warned"));
    	inv.setItem(3, API.createItem("&b" + sentbyplayer.getName(), Material.PAPER, "&fYou are: " + sentbyplayer.getName()));
    	inv.setItem(5, API.createItem("&fPlugin made by:", Material.PAPER, "&bJustBru00"));
    	inv.setItem(18, API.createItem(API.color(main.getConfigString("gui.third row.displaynames.one")), Material.PAPER, API.color("&cAction: " + main.getConfigString("warning options.options.one"))));
    	inv.setItem(20, API.createItem(API.color(main.getConfigString("gui.third row.displaynames.two")), Material.PAPER, API.color("&cAction: " + main.getConfigString("warning options.options.two"))));	
    	inv.setItem(22, API.createItem(API.color(main.getConfigString("gui.third row.displaynames.three")), Material.PAPER, API.color("&cAction: " + main.getConfigString("warning options.options.three"))));
    	inv.setItem(24, API.createItem(API.color(main.getConfigString("gui.third row.displaynames.four")), Material.PAPER, API.color("&cAction: " + main.getConfigString("warning options.options.four"))));
    	inv.setItem(26, API.createItem(API.color(main.getConfigString("gui.third row.displaynames.five")), Material.PAPER, API.color("&cAction: " + main.getConfigString("warning options.options.five"))));
    	inv.setItem(27, API.createItem(API.color(main.getConfigString("gui.fourth row.displaynames.one")), Material.PAPER, API.color("&cAction: " + main.getConfigString("warning options.options.six"))));
    	inv.setItem(29, API.createItem(API.color(main.getConfigString("gui.fourth row.displaynames.two")), Material.PAPER, API.color("&cAction: " + main.getConfigString("warning options.options.seven"))));
    	inv.setItem(31, API.createItem(API.color(main.getConfigString("gui.fourth row.displaynames.three")), Material.PAPER, API.color("&cAction: " + main.getConfigString("warning options.options.eight"))));
    	
		return inv;
	}
	
}

/**
 *  0  1  2  .3  .4  .5  6  7  8
 *  9 10 11 12 13 14 15 16 17
 * .18 19 .20 21 .22 23 .24 25 .26
 * .27 28 .29 30 .31 32 .34 35 .36
 * .37 38 .39 40 .41 42 .43 44 .45
 * .46 47 .48 49 .50 51 .52 53 .54
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

