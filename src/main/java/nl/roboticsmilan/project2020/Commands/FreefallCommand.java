package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.GUI.FreefallMenu;
import nl.roboticsmilan.project2020.Main;
import nl.roboticsmilan.project2020.Rides.Freefall.Freefall;
import nl.roboticsmilan.project2020.Rides.Freefall.FreefallHandler;
import nl.roboticsmilan.project2020.Util.Cuboid;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreefallCommand implements CommandExecutor {

    public Cuboid besturing = new Cuboid(new Location(Main.getWorld(), -178, 5, 99), new Location(Main.getWorld(), -175, 8, 103));

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("themepark.freefall")) {
            if (args[0].equalsIgnoreCase("spawn")) {
                new Freefall();
                new FreefallHandler();
            }
            if (args[0].equalsIgnoreCase("start")) {
                 Freefall.startProgram();
            }
            if (args[0].equalsIgnoreCase("operate")) {
                Player p = (Player) sender;
                if (besturing.contains(p.getLocation())) {
                    FreefallMenu.open(p);
                } else {
                    sender.sendMessage(ChatColor.RED + "Je moet in het besturingshok zijn om het menu te openen");
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Je hebt geen permissie voor dit command");
        }
        return false;
    }
}
