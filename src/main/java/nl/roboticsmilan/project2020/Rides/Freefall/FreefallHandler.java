package nl.roboticsmilan.project2020.Rides.Freefall;

import nl.roboticsmilan.project2020.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class FreefallHandler {

    public static ArrayList<Player> riders = new ArrayList<>();
    public static boolean automatic = true;
    public static boolean dispatched = false;
    private static int seconds = 10;
    public static BossBar bb;

    public FreefallHandler() {
        bb = Bukkit.createBossBar(ChatColor.GOLD + "The Freefall will start in " + ChatColor.YELLOW + seconds + ChatColor.GOLD + " seconds", BarColor.YELLOW, BarStyle.SEGMENTED_10);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (automatic) {
                    if (!dispatched) {
                        if (riders.size() > 0) {
                            seconds -= 1;
                            bb.setTitle(ChatColor.GOLD + "The Freefall will start in " + ChatColor.YELLOW + seconds + ChatColor.GOLD + " seconds");
                            double per = 1.0/10.0*Double.valueOf(seconds);
                            bb.setProgress(per);
                            for (Player p  : Bukkit.getOnlinePlayers()) {
                                if (riders.contains(p)) {
                                    if (!bb.getPlayers().contains(p)) {
                                        bb.addPlayer(p);
                                    }
                                } else if (bb.getPlayers().contains(p)) {
                                    bb.removePlayer(p);
                                }
                            }
                            if (seconds < 1) {
                                Freefall.startProgram();
                                seconds = 10;
                            }
                        } else {
                            seconds = 10;
                            bb.removeAll();
                        }
                    } else {
                        seconds = 10;
                        bb.removeAll();
                    }
                } else {
                    seconds = 10;
                    bb.removeAll();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 20L);
    }

}
