package nl.roboticsmilan.project2020.GUI;

import nl.roboticsmilan.project2020.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class FreefallMenu {

    public static Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Freefall - Operator");

    public FreefallMenu() {
        inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Freefall - Operator");
        ItemBuilder.create(ChatColor.GOLD + "Status", ChatColor.RED + "Gesloten", "", Material.RED_CONCRETE, inv, 8);
        ItemBuilder.create(ChatColor.GOLD + "Poortjes", ChatColor.RED + "Gesloten", "", Material.GREEN_CONCRETE, inv, 11);
        ItemBuilder.create(ChatColor.GOLD + "Vrijgeven", ChatColor.RED + "Afgewezen", "", Material.GRAY_CONCRETE, inv, 13);
        ItemBuilder.create(ChatColor.GOLD + "Beugels", ChatColor.RED + "Gesloten", "", Material.GREEN_CONCRETE, inv, 15);
    }

    public static void open(Player p) {
        p.openInventory(inv);
    }
}
