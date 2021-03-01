package nl.roboticsmilan.project2020.Events;

import nl.roboticsmilan.project2020.Rides.Freefall.FreefallHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class SeatEvent implements Listener {

    @EventHandler
    public void onSeatClick(PlayerInteractAtEntityEvent e) {
        if (e.getRightClicked().getPassengers().isEmpty()) {
            if (!e.getPlayer().isInsideVehicle()) {
                if ((e.getRightClicked().getCustomName() != null) && (e.getRightClicked().getCustomName().equalsIgnoreCase("Freefall_SEAT")) && (e.getRightClicked().getPassenger() == null)) {
                    e.getRightClicked().addPassenger(e.getPlayer());
                    if (!FreefallHandler.riders.contains(e.getPlayer())) {
                        FreefallHandler.riders.add(e.getPlayer());
                    }
                }
            }
        }
    }
}
