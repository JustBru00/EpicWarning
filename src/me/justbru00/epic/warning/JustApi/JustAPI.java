/**
*This API is for usage with plugins by Justin Brubaker and for usage by open source projects.
*Contact Justin Brubaker @ justbru00@gmail.com
*
*   
*   Copyright (C) 2015  Justin Brubaker
*
*   This program is free software; you can redistribute it and/or modify
*   it under the terms of the GNU General Public License as published by
*    the Free Software Foundation; either version 2 of the License, or
*    (at your option) any later version.
*
*    This program is distributed in the hope that it will be useful,
*    but WITHOUT ANY WARRANTY; without even the implied warranty of
*    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*    GNU General Public License for more details.
*
*    You should have received a copy of the GNU General Public License along
*    with this program; if not, write to the Free Software Foundation, Inc.,
*    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*/
package me.justbru00.epic.warning.JustApi;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class JustAPI {

	public static ItemStack createSkull(String owner, String noncoloredDisplayName) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sm = (SkullMeta) is.getItemMeta();		
		sm.setOwner(owner);
		sm.setDisplayName(color(noncoloredDisplayName));
		is.setItemMeta(sm);		
		return is;		
	}
	
	public static ItemStack createSkullwithLore(String noncoloredDisplayName, String owner, String lore) {
		ItemStack is = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
		SkullMeta sm = (SkullMeta) is.getItemMeta();		
		sm.setOwner(owner);
		ArrayList<String> reallore = new ArrayList<String>();
		reallore.add(color(lore));
		sm.setDisplayName(color(noncoloredDisplayName));
		sm.setLore(reallore);
		is.setItemMeta(sm);		
		return is;		
	}
	
	public static ItemStack renameItemStack(ItemStack toRename, String Displayname) {
		ItemStack is = toRename;
		ItemMeta im = is.getItemMeta();	
		im.setDisplayName(color(Displayname));
		is.setItemMeta(im);		
		return is;
	}
	
	public static Inventory createInv(String name, int slots) {
		Inventory inv = Bukkit.createInventory(null, slots, name);
		return inv;
	}
	
	public static String color(String uncolored) {
		String colored = ChatColor.translateAlternateColorCodes('&', uncolored);
	return colored;	
	}
	
	public static ItemStack createItem(String displayName, Material m, String lore) {
		ItemStack is = new ItemStack(m);
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(color(displayName));
		ArrayList<String> reallore = new ArrayList<String>();
		reallore.add(color(lore));
		im.setLore(reallore);
		is.setItemMeta(im);
		return is;
	}
}