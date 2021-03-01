package nl.roboticsmilan.project2020.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HalloCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.sendMessage(ChatColor.YELLOW + "Hallo, " + ChatColor.GOLD +  sender.getName() + ChatColor.YELLOW +  "! Wat leuk dat je een kijkje neemt op mijn server");
        } else {
            sender.sendMessage("Dit commando kan alleen uitgevoerd worden door een speler");
        }
        return false;
    }
}
