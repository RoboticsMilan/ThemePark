package nl.roboticsmilan.project2020.Commands;

import nl.roboticsmilan.project2020.Data.Warps;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            for (Warps warp : Warps.values()) {
                if (warp.getName().equalsIgnoreCase(args[0])) {
                    Player p = (Player) sender;
                    p.teleport(warp.getLoc());
                    p.teleport(warp.getLoc());
                    p.sendMessage(ChatColor.DARK_GRAY + "Warping to " + warp.getName() + "....");
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Verkeerde argumenten gebruik /warp (warpnaam)");
        }
        return false;
    }
}
