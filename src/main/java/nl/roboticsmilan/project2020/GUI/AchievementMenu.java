package nl.roboticsmilan.project2020.GUI;

import nl.roboticsmilan.project2020.Data.Achievement;
import nl.roboticsmilan.project2020.Data.Achievements;
import nl.roboticsmilan.project2020.Util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class AchievementMenu {

    public AchievementMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 45, ChatColor.GOLD + "Achievements Menu");
        int i = -1;
        for (Achievement a : Achievement.values()) {
            i++;
            if (Achievements.heeftAchievement(a, p)) {
                ItemBuilder.create(ChatColor.GOLD + a.getName(), ChatColor.YELLOW + a.getDescription(), ChatColor.GRAY + "Reward: " + a.getCoins() + " coins.", Material.GREEN_CONCRETE, inv, i);
            } else {
                ItemBuilder.create(ChatColor.GRAY + "???", "", "", Material.RED_CONCRETE, inv, i);
            }
        }
        p.openInventory(inv);
    }
}
