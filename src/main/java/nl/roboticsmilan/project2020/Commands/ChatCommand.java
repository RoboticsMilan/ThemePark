package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("themepark.chat")) {
            if (args.length != 0) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("clear")) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            for (int i = 0; i < 500; i++) {
                                p.sendMessage("");
                            }
                            p.sendMessage(ChatColor.RED + "De chat is leeggemaakt door " + ((Player) sender).getName());
                        }
                    }
                    if (args[0].equalsIgnoreCase("toggle")) {
                        if (Boolean.valueOf(Main.getPlugin().getConfig().get("chatmute").toString())) {
                            Main.getPlugin().getConfig().set("chatmute", false);
                            Main.getPlugin().saveConfig();
                            sender.sendMessage(ChatColor.GREEN + "De chat is nu geunmuted");
                        } else {
                            Main.getPlugin().getConfig().set("chatmute", true);
                            Main.getPlugin().saveConfig();
                            sender.sendMessage(ChatColor.RED + "De chat is nu gemuted");
                        }
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + "/chat clear|toggle");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "/chat clear|toggle");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Geen permissies");
        }
        return false;
    }
}
