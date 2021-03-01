package nl.roboticsmilan.project2020.Events;

import nl.roboticsmilan.project2020.Data.PlayerData;
import nl.roboticsmilan.project2020.Tasks.Scoreboard;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPermission("themepark.staff")) {
            e.setJoinMessage(ChatColor.GRAY + e.getPlayer().getName() + ChatColor.LIGHT_PURPLE + " (Staff)" + ChatColor.GRAY + " has Joined the Server");
        } else {
            e.setJoinMessage(ChatColor.GRAY + e.getPlayer().getName() + " has Joined the Server");
        }
        if (!PlayerData.existsPlayerData(e.getPlayer())) {
            PlayerData.createPlayerData(e.getPlayer());
        }
        Scoreboard.setupScoreboard(e.getPlayer());
    }
}
