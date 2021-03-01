package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.Data.RideCounter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RidecounterCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("add")) {
                if (args.length == 3) {
                    if (sender instanceof Player) {
                        if (sender.hasPermission("themepark.ridecounter")) {
                            RideCounter.addRideCount(Bukkit.getPlayer(args[1]), args[2]);
                            sender.sendMessage(ChatColor.GOLD + "Je hebt " + Bukkit.getPlayer(args[1]).getName() + " een ridecount gegeven op " + args[2]);
                        } else {
                            sender.sendMessage(ChatColor.RED + "No permission");
                        }
                    } else {
                        RideCounter.addRideCount(Bukkit.getPlayer(args[1]), args[2]);
                        Bukkit.getLogger().info("Je hebt " + Bukkit.getPlayer(args[1]).getName() + " een ridecount gegeven op " + args[2]);
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "/ridecounter add [player] [ride]");
                }
            }
            if (args[0].equalsIgnoreCase("get")) {
                if (sender instanceof Player) {
                    if (args.length == 2) {
                        sender.sendMessage(ChatColor.GOLD + "Je ridecount op " + ChatColor.YELLOW + args[1] + ChatColor.GOLD + " is op dit moment: " + ChatColor.YELLOW + RideCounter.getRideCount((Player) sender, args[1]));
                    } else if (args.length == 3) {
                        sender.sendMessage(ChatColor.GOLD + "De ridecount van " + Bukkit.getPlayer(args[1]).getName() + " op " + ChatColor.YELLOW + args[2] + ChatColor.GOLD + " is op dit moment: " + ChatColor.YELLOW + RideCounter.getRideCount(Bukkit.getPlayer(args[1]), args[2]));
                    } else {
                        sender.sendMessage(ChatColor.RED + "/ridecounter get [ride] of /ridecounter get [player] [ride]");
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "/ridecounter add|get");
        }
        return false;
    }
}
