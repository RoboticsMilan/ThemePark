package nl.roboticsmilan.project2020.GUI;

import nl.roboticsmilan.project2020.Data.Coins;
import nl.roboticsmilan.project2020.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class ProfileMenu {

    public ProfileMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9, ChatColor.GOLD + "Profile of " + p.getName());
        ItemBuilder.createSkull(ChatColor.BLUE + "Player:" + p.getName(), ChatColor.GRAY + "Coins: " + Coins.getCoins(p), ChatColor.GRAY + "Current Location: " +  p.getLocation().getBlockX() + " " + p.getLocation().getBlockY() + " " + p.getLocation().getBlockZ(), p.getName(), inv, 4);
        ItemBuilder.create("Back", "", "", Material.BARRIER, inv, 8);
        ItemBuilder.create("Back", "", "", Material.BARRIER, inv, 0);
        p.openInventory(inv);
    }
}
