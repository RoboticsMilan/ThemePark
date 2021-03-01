package nl.roboticsmilan.project2020.Rides.Freefall;

import nl.roboticsmilan.project2020.GUI.FreefallMenu;
import nl.roboticsmilan.project2020.Main;
import nl.roboticsmilan.project2020.Util.ItemBuilder;
import nl.roboticsmilan.project2020.Util.SignUpdater;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.scheduler.BukkitRunnable;

public class FreefallUpdater {

    public static boolean gates = true;
    public static boolean restraints = true;
    public static boolean canDispatch = false;
    public static boolean rideStatus = false;

    public FreefallUpdater() {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!FreefallHandler.dispatched && gates && restraints && rideStatus) {
                    canDispatch = true;
                } else {
                    canDispatch = false;
                }
                if (!FreefallHandler.dispatched) {
                    if (rideStatus) {
                        ItemBuilder.create(ChatColor.GOLD + "Status", ChatColor.GREEN + "Geopend", "", Material.GREEN_CONCRETE, FreefallMenu.inv, 8);
                        SignUpdater.updateSign(new Location(Main.getWorld(), -165, 9, 119), 2, ChatColor.GREEN + "Geopend");
                        Main.getWorld().getBlockAt(-162, 8, 120).setType(Material.AIR);
                        Main.getWorld().getBlockAt(-163, 8, 120).setType(Material.AIR);
                        Main.getWorld().getBlockAt(-164, 8, 120).setType(Material.AIR);
                    } else {
                        ItemBuilder.create(ChatColor.GOLD + "Status", ChatColor.RED + "Gesloten", "", Material.RED_CONCRETE, FreefallMenu.inv, 8);
                        SignUpdater.updateSign(new Location(Main.getWorld(), -165, 9, 119), 2, ChatColor.RED + "Gesloten");
                        Main.getWorld().getBlockAt(-162, 8, 120).setType(Material.IRON_BARS);
                        Main.getWorld().getBlockAt(-163, 8, 120).setType(Material.IRON_BARS);
                        Main.getWorld().getBlockAt(-164, 8, 120).setType(Material.IRON_BARS);
                    }
                    if (gates) {
                        ItemBuilder.create(ChatColor.GOLD + "Poortjes", ChatColor.RED + "Gesloten", "", Material.GREEN_CONCRETE, FreefallMenu.inv, 11);
                        Main.getWorld().getBlockAt(-168, 3, 110).setType(Material.AIR);
                    } else {
                        ItemBuilder.create(ChatColor.GOLD + "Poortjes", ChatColor.GREEN + "Geopend", "", Material.RED_CONCRETE, FreefallMenu.inv, 11);
                        Main.getWorld().getBlockAt(-168, 3, 110).setType(Material.REDSTONE_TORCH);
                    }
                    if (canDispatch) {
                        ItemBuilder.create(ChatColor.GOLD + "Vrijgeven", ChatColor.GREEN + "Toegestaan", "", Material.GREEN_CONCRETE, FreefallMenu.inv, 13);
                    } else {
                        ItemBuilder.create(ChatColor.GOLD + "Vrijgeven", ChatColor.RED + "Afgewezen", "", Material.GRAY_CONCRETE, FreefallMenu.inv, 13);
                    }
                    if (restraints) {
                        ItemBuilder.create(ChatColor.GOLD + "Beugels", ChatColor.RED + "Gesloten", "", Material.GREEN_CONCRETE, FreefallMenu.inv, 15);
                    } else {
                        ItemBuilder.create(ChatColor.GOLD + "Beugels", ChatColor.GREEN + "Geopend", "", Material.RED_CONCRETE, FreefallMenu.inv, 15);
                    }
                } else {
                    ItemBuilder.create(ChatColor.GOLD + "Status", ChatColor.GREEN + "Geopend", "", Material.GRAY_CONCRETE, FreefallMenu.inv, 8);
                    ItemBuilder.create(ChatColor.GOLD + "Poortjes", ChatColor.RED + "Gesloten", "", Material.GRAY_CONCRETE, FreefallMenu.inv, 11);
                    ItemBuilder.create(ChatColor.GOLD + "Vrijgeven", ChatColor.GREEN + "Toegestaan", "", Material.GRAY_CONCRETE, FreefallMenu.inv, 13);
                    ItemBuilder.create(ChatColor.GOLD + "Beugels", ChatColor.RED + "Gesloten", "", Material.GRAY_CONCRETE, FreefallMenu.inv, 15);
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 1L);
    }
}
