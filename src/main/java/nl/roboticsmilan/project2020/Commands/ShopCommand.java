package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.GUI.ShopMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        new ShopMenu((Player) sender);
        return false;
    }
}
