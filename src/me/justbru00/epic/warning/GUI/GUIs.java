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
