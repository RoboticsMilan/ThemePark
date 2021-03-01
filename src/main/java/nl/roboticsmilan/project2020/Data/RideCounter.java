package nl.roboticsmilan.project2020.Data;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class RideCounter {

    public static int getRideCount(Player p, String ride) {
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(f);
        if (conf.get("ridecounter." + ride) != null) {
            int i = Integer.valueOf(conf.get("ridecounter." + ride).toString());
            return i;
        } else {
            conf.set("ridecounter." + ride, 0);
            try {
                conf.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    public static void addRideCount(Player p, String ride) {
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(f);
        conf.set("ridecounter." + ride, Integer.valueOf(getRideCount(p, ride)+1));
        try {
            conf.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        p.sendMessage(ChatColor.GOLD + "Je hebt " + ChatColor.YELLOW + ride + ChatColor.GOLD + " nu " + ChatColor.YELLOW + getRideCount(p, ride) + ChatColor.GOLD + " keer bezocht.");
    }
}
