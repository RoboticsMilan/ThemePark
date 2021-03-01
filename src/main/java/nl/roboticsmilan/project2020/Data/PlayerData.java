package nl.roboticsmilan.project2020.Data;

import nl.roboticsmilan.project2020.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class PlayerData {

    public static boolean existsPlayerData(Player p) {
        File f = new File(Main.getPlugin().getDataFolder()+"/player-data/", p.getUniqueId().toString()+".yml");
        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void createPlayerData(Player p) {
        if (!existsPlayerData(p)) {
            File f = new File(Main.getPlugin().getDataFolder()+"/player-data/", p.getUniqueId().toString()+".yml");
            File folder = new File(Main.getPlugin().getDataFolder()+"/player-data/", "");
            folder.mkdirs();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            config.set("playername", p.getName());
            config.set("coins", 0);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static File getPlayerDataFile(Player p) {
        if (existsPlayerData(p)) {
            return new File(Main.getPlugin().getDataFolder() + "/player-data/", p.getUniqueId().toString() + ".yml");
        } else {
            return null;
        }
    }


}
