/**
 * THE (“EpicWarning”) SOURCE IS PROVIDED AS IS AT NO MONETARY COST FOR PERSONAL USE ONLY.
 * ANY COMMERCIAL OR NON-COMMERCIAL DISTRIBUTION/USE OF THE (“EpicWarning”) SOURCE IS STRICTLY PROHIBITED.
 */
package me.justbru00.epic.warning.Listeners;

import java.util.Calendar;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import me.justbru00.epic.warning.main.Main;

public class JoinWatcher implements Listener {

	Main main;
	
	public JoinWatcher(Main main) {
		this.main = main;
	}

	
	@EventHandler
	public void onLogin(PlayerLoginEvent e) {
		
		String playerUUID = e.getPlayer().getUniqueId().toString();	
		long currentTime = System.currentTimeMillis();
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(currentTime);

		int Year = calendar.get(Calendar.YEAR);
		int Month = calendar.get(Calendar.MONTH);
		int Day = calendar.get(Calendar.DAY_OF_MONTH);
		int Hour = calendar.get(Calendar.HOUR);
		int Min = calendar.get(Calendar.MINUTE);
		int Sec = calendar.get(Calendar.SECOND);
		
	
		
		
		if (main.points.getBoolean(playerUUID + ".banned")) {
			e.disallow(Result.KICK_BANNED, Main.color("&cYou are banned by &f" + main.points.getString(playerUUID + ".bannedby") 
			+ " &cfor: &f" + main.points.getString(playerUUID + ".bannedreason")));
			return;
			
		} else if (main.points.getBoolean(playerUUID + ".tempbanned")) {			
			
			
			// Temp
			//if () {
			//	e.disallow(Result.KICK_BANNED, Main.color("&cYou are tempbanned by &f" + main.points.getString(playerUUID + ".tempbannedby") 
			//	+ " &cfor: &f" + main.points.getString(playerUUID + ".tempbanreason") + "&c Until: &f" + main.points.getString(playerUUID + ".tempbanreason")));
			//	return;
			//}
			
			return;
		}	
		
		
	}
}
