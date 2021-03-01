package nl.roboticsmilan.project2020.GUI;

import nl.roboticsmilan.project2020.Main;
import nl.roboticsmilan.project2020.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class RideMenu {

    private static Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "AttractieMenu");


    public static void update() {
        if (Boolean.valueOf(Main.getPlugin().getConfig().get("status.test").toString())) {
            ItemBuilder.create(ChatColor.GOLD + "Test Attractie", ChatColor.GRAY + "Status: Geopend", "", Material.GREEN_CONCRETE, inv, 0);
        } else {
            ItemBuilder.create(ChatColor.GOLD + "Test Attractie", ChatColor.GRAY + "Status: Gesloten", "", Material.RED_CONCRETE, inv, 0);
        }
        if (Boolean.valueOf(Main.getPlugin().getConfig().get("status.test").toString())) {
            ItemBuilder.createDurability(ChatColor.GOLD + "Spawn", ChatColor.GRAY + "Status: Geopend", "", Material.DIAMOND_SWORD, (short)1, inv, 1);
        } else {
            ItemBuilder.create(ChatColor.GOLD + "Spawn", ChatColor.GRAY + "Status: Gesloten", "", Material.RED_CONCRETE, inv, 1);
        }
    }

    public static void openMenu(Player p) {
        p.openInventory(inv);
    }
}
