package nl.roboticsmilan.project2020.Events;

import nl.roboticsmilan.project2020.Rides.Freefall.FreefallHandler;
import nl.roboticsmilan.project2020.Rides.Freefall.FreefallUpdater;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.spigotmc.event.entity.EntityDismountEvent;

public class ExitSeatEvent implements Listener {

    @EventHandler
    public void onDismount(EntityDismountEvent e) {
        if (e.getDismounted().getCustomName().equalsIgnoreCase("Freefall_SEAT")) {
            if (FreefallHandler.riders.contains(e.getEntity())) {
                if (!FreefallUpdater.restraints) {
                    FreefallHandler.riders.remove(e.getEntity());
                    FreefallHandler.bb.removePlayer((Player) e.getEntity());
                } else {
                    e.setCancelled(true);
                }
            }
        }
    }
}
