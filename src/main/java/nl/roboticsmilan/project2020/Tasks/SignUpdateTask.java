package nl.roboticsmilan.project2020.Tasks;

import nl.roboticsmilan.project2020.Events.MoveEvent;
import nl.roboticsmilan.project2020.Main;
import nl.roboticsmilan.project2020.Util.SignUpdater;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SignUpdateTask {

    public SignUpdateTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                int i = 0;
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (MoveEvent.huisSign.contains(p.getLocation())) {
                        i++;
                    }
                }
                if (i > 0) {
                    SignUpdater.updateSign(new Location(Main.getWorld(), -200, 6, -270), 2, ChatColor.GREEN + "Er is " + i + " persoon");
                } else {
                    SignUpdater.updateSign(new Location(Main.getWorld(), -200, 6, -270), 2, ChatColor.RED + "Er is niemand thuis");

                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 20*5L);
    }
}
