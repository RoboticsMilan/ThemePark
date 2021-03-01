package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.GUI.AchievementMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AchievementCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            new AchievementMenu((Player) sender);
            sender.sendMessage(ChatColor.GRAY + "Het menu is geopend");
        } else {
            sender.sendMessage(ChatColor.RED + "Je moet een speler zijn om het menu te kunnen openen");
        }
        return false;
    }
}
