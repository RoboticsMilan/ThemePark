package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.Data.Coins;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("themepark.economy")) {
            if (args.length == 0) {
                sender.sendMessage(ChatColor.YELLOW + "Coin Balance: " + Coins.getCoins((Player)sender));
                return false;
            }
            if (args[0].equalsIgnoreCase("add")) {
                if (args.length == 3) {
                    OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
                    if (player.isOnline()) {
                        Coins.setCoins(player.getPlayer(), Coins.getCoins(player.getPlayer())+Integer.valueOf(args[2]));
                    } else {
                        sender.sendMessage(ChatColor.RED + "Speler is niet online");
                    }
                } else {
                    sender.sendMessage(ChatColor.GREEN + "/economy add [player] [coins]");
                }
            }
            if (args[0].equalsIgnoreCase("remove")) {
                if (args.length == 3) {
                    OfflinePlayer player = Bukkit.getOfflinePlayer(args[1]);
                    if (player.isOnline()) {
                        Coins.setCoins(player.getPlayer(), Coins.getCoins(player.getPlayer())-Integer.valueOf(args[2]));
                    } else {
                        sender.sendMessage(ChatColor.RED + "Speler is niet online");
                    }
                } else {
                    sender.sendMessage(ChatColor.GREEN + "/economy remove [player] [coins]");
                }
            }
            if (args[0].equalsIgnoreCase("reset")) {
                if (args.length == 2) {
                    OfflinePlayer player = Bukkit.getPlayer(args[1]);
                    if (player.isOnline()) {
                        Coins.resetCoins(player.getPlayer());
                    } else {
                        sender.sendMessage(ChatColor.RED + "Speler is niet online");
                    }
                } else {
                    sender.sendMessage(ChatColor.GREEN + "/economy reset [player]");
                }
            }
        }
        return false;
    }
}
