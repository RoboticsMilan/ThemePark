package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.GUI.RideMenu;
import nl.roboticsmilan.project2020.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RideCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("themepark.ridemenu")) {
            if (args.length == 0) {
                RideMenu.openMenu((Player) sender);
                return false;
            }
            if (args[0].equalsIgnoreCase("setstatus")) {
                if (sender.hasPermission("themepark.ridemenu.admin")) {
                    if (args[1].equalsIgnoreCase("test")) {
                        if (args[2].equalsIgnoreCase("gesloten") || args[2].equalsIgnoreCase("open")) {
                            if (args[2].equalsIgnoreCase("gesloten")) {
                                if (Boolean.valueOf(Main.getPlugin().getConfig().get("status.test").toString())) {
                                    Main.getPlugin().getConfig().set("status.test", false);
                                    Main.getPlugin().saveConfig();
                                    sender.sendMessage(ChatColor.GREEN + "De Attractie word nu gesloten");
                                    Bukkit.getServer().broadcastMessage(ChatColor.RED + "Test Attractie is Gesloten");
                                    RideMenu.update();
                                } else {
                                    sender.sendMessage(ChatColor.RED + "Deze attractie is al op dit moment gesloten");
                                }
                            }
                            if (args[2].equalsIgnoreCase("open")) {
                                if (!Boolean.valueOf(Main.getPlugin().getConfig().get("status.test").toString())) {
                                    Main.getPlugin().getConfig().set("status.test", true);
                                    Main.getPlugin().saveConfig();
                                    sender.sendMessage(ChatColor.GREEN + "De Attractie word nu geopend");
                                    Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Test Attractie is Geopend");
                                    RideMenu.update();
                                } else {
                                    sender.sendMessage(ChatColor.RED + "Deze attractie is al op dit moment geopend");
                                }
                            }
                        } else {
                            sender.sendMessage(ChatColor.RED + "De Status kan niet worden gevonden gebruik gesloten of open");
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "Attractie kan niet gevonden worden");
                    }
                }
            }
        }
        return false;
    }
}
