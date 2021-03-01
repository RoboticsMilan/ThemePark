package nl.roboticsmilan.project2020.GUI;

import nl.roboticsmilan.project2020.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ShopMenu {

    public ShopMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Test Shop");
        ItemBuilder.create(ChatColor.GOLD + "Grass", ChatColor.GRAY + "Prijs: 5 Coins", ChatColor.GRAY + "Klik hier om dit te kopen", Material.GRASS_BLOCK, inv, 3);
        ItemBuilder.create(ChatColor.GOLD + "Stone", ChatColor.GRAY + "Prijs: 10 Coins", ChatColor.GRAY + "Klik hier om dit te kopen", Material.STONE, inv, 4);
        ItemBuilder.create(ChatColor.GOLD + "Dirt", ChatColor.GRAY + "Prijs: 5 Coins", ChatColor.GRAY + "Klik hier om dit te kopen", Material.DIRT, inv, 5);
        p.openInventory(inv);
    }
}
