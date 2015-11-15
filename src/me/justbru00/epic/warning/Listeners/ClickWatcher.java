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
package me.justbru00.epic.warning.Listeners;


import org.bukkit.event.Listener;

import me.justbru00.epic.warning.main.Main;

public class ClickWatcher implements Listener {

	Main main;
	
	public ClickWatcher(Main main) {
		this.main = main;
	}
}
