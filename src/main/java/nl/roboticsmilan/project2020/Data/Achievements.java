package nl.roboticsmilan.project2020.Data;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Achievements {

    public static boolean heeftAchievement(Achievement ach, Player p) {
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        if (config.get("achievements." + ach.getId()) != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void geefAchievement(Achievement ach, Player p) {
        if (!heeftAchievement(ach, p)) {
            File f = PlayerData.getPlayerDataFile(p);
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            config.set("achievements." + ach.getId(), true);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Coins.setCoins(p, Coins.getCoins(p)+ach.getCoins());
            p.sendMessage(ChatColor.GOLD + "Achievement Behaald! \n " + ChatColor.GREEN + ChatColor.BOLD.toString() + ach.getName() + "\n" + ChatColor.GRAY + ChatColor.ITALIC.toString() + ach.getDescription() + "\n " + ChatColor.DARK_GRAY + "Reward: " + ach.getCoins() + " coins.");

        }
    }
}
