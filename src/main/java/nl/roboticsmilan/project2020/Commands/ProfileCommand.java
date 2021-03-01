package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.GUI.ProfileMenu;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ProfileCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            new ProfileMenu((Player) sender);
            sender.sendMessage(ChatColor.GREEN + "Het menu is geopend");
        } else {
            sender.sendMessage(ChatColor.RED + "Je kunt dit commando alleen uitvoeren als speler");
        }
        return false;
    }
}
