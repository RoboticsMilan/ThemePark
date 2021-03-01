package nl.roboticsmilan.project2020.Tasks;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import nl.roboticsmilan.project2020.Data.Coins;
import nl.roboticsmilan.project2020.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CoinTimer {

    public CoinTimer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    Coins.setCoins(p, Coins.getCoins(p)+1);
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GREEN + "You recieved 1 coin for being online!"));
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 20L*60);
    }
}
