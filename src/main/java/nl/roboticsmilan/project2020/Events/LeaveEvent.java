package nl.roboticsmilan.project2020.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

    @EventHandler
    public void onLeft(PlayerQuitEvent e) {
        e.setQuitMessage(ChatColor.DARK_GRAY + e.getPlayer().getName() + " has left the server.");
    }
}
