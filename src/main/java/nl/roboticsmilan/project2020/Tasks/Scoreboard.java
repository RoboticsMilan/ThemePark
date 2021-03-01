package nl.roboticsmilan.project2020.Tasks;

import nl.roboticsmilan.project2020.Data.Coins;
import nl.roboticsmilan.project2020.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;

public class Scoreboard {

    public static void setupScoreboard(Player p) {
        new BukkitRunnable() {
            String pname = p.getName();
            @Override
            public void run() {
                if (Bukkit.getOfflinePlayer(pname).isOnline()) {
                    updateBoard(p);
                } else {
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 50L);
    }

    private static void updateBoard(Player p) {
        ScoreboardManager m = Bukkit.getScoreboardManager();
        org.bukkit.scoreboard.Scoreboard b = m.getNewScoreboard();
        Objective obj = b.registerNewObjective("sideboard", "dummy");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(ChatColor.GOLD + ChatColor.BOLD.toString() + "Project 2020");
        Score online = obj.getScore(ChatColor.GRAY + "Online Players:");
        online.setScore(Bukkit.getOnlinePlayers().size());
        Score coins = obj.getScore(ChatColor.GRAY + "Coins: ");
        coins.setScore(Coins.getCoins(p));
        p.setScoreboard(b);
    }
}
