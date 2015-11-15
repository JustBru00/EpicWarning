package me.justbru00.epic.warning.utils;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.justbru00.epic.warning.main.Main;

public class ItemMaker {
	
	public static final int NO_DATA_VALUE = -1;
	private static ItemStack is;

	public static ItemStack createItem(String material, String name, short dataValue) {		
		if (dataValue == ItemMaker.NO_DATA_VALUE) {
			 is = new ItemStack(Material.getMaterial(material), 1);
		} else {
		     is = new ItemStack(Material.getMaterial(material), 1, dataValue);
		}
		
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(Main.color(name));
		
		is.setItemMeta(im);
		return is;
	}
	
	public static ItemStack createItem(String material, String name, String lore, short dataValue) {
		
		ArrayList<String> loreList = new ArrayList<String>();
		loreList.add(Main.color(lore));
		
		if (dataValue == ItemMaker.NO_DATA_VALUE) {
			 is = new ItemStack(Material.getMaterial(material), 1);
		} else {
		     is = new ItemStack(Material.getMaterial(material), 1, dataValue);
		}
		
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(Main.color(name));
		
		is.setItemMeta(im);
		return is;
	}
}
