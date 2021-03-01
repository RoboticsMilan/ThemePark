package nl.roboticsmilan.project2020.Events;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import nl.roboticsmilan.project2020.Data.Achievement;
import nl.roboticsmilan.project2020.Data.Achievements;
import nl.roboticsmilan.project2020.Data.Region;
import nl.roboticsmilan.project2020.Main;
import nl.roboticsmilan.project2020.Util.Cuboid;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    public static Cuboid huisSign = new Cuboid(new Location(Main.getWorld(), -202, 4, -270), new Location(Main.getWorld(), -204, 9, -268));

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        for (Region reg : Region.values()) {
            if (reg.getRegion().contains(e.getPlayer().getLocation())) {
                if (reg.canShowName()) {
                    e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatColor.GOLD + reg.getName()));
                }
                for (Achievement a : Achievement.values()) {
                    if (a.getId().equalsIgnoreCase(reg.name())) {
                        if (!Achievements.heeftAchievement(a, e.getPlayer())) {
                            Achievements.geefAchievement(a, e.getPlayer());
                        }
                    }
                }
            }
        }
    }
}
