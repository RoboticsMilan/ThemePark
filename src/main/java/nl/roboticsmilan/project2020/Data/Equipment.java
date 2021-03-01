package nl.roboticsmilan.project2020.Data;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class Equipment {

    public static boolean heeftEquipment(String naam, Player p) {
        File f = PlayerData.getPlayerDataFile(p);
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        if (config.get("equipment." + naam) != null) {
            return true;
        } else {
            return false;
        }
    }

    public static void geefEquipment(String naam, Player p) {
        if (!heeftEquipment(naam, p)) {
            File f = PlayerData.getPlayerDataFile(p);
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            config.set("equipment." + naam, true);
            try {
                config.save(f);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
