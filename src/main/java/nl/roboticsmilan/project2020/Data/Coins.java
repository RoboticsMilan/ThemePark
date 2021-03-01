package nl.roboticsmilan.project2020.Data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Coins {

    public static int getCoins(Player p) {
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        return Integer.parseInt(config.get("coins").toString());
    }

    public static void setCoins(Player p, int coins) {
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        config.set("coins", coins);
        try {
            config.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void resetCoins(Player p) {
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        config.set("coins", 0);
        try {
            config.save(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
