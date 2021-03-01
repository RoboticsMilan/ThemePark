package nl.roboticsmilan.project2020.Events;

import nl.roboticsmilan.project2020.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        if (Boolean.valueOf(Main.getPlugin().getConfig().get("chatmute").toString())) {
            if (!e.getPlayer().hasPermission("themepark.chatbypass")) {
                e.getPlayer().sendMessage(ChatColor.RED + "De chat is gemuted");
                e.setCancelled(true);
            } else {
                e.setCancelled(false);
            }
        }
    }
}
