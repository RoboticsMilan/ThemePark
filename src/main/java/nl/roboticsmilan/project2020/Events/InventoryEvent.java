package nl.roboticsmilan.project2020.Events;

import nl.roboticsmilan.project2020.Data.Coins;
import nl.roboticsmilan.project2020.Data.Equipment;
import nl.roboticsmilan.project2020.Rides.Freefall.Freefall;
import nl.roboticsmilan.project2020.Rides.Freefall.FreefallUpdater;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() != null) {
            if (e.getCurrentItem() != null) {
                if (e.getView().getTitle().startsWith(ChatColor.GOLD + "Profile of ")) {
                    e.setCancelled(true);
                    switch (e.getCurrentItem().getType()) {
                        case BARRIER:
                            e.getWhoClicked().closeInventory();
                            break;
                        default:
                            break;
                    }
                }
                if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "AttractieMenu")) {
                    e.setCancelled(true);
                    switch (e.getCurrentItem().getType()) {
                        case GREEN_CONCRETE:
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Test Attractie")) {
                                Player p = (Player) e.getWhoClicked();
                                p.performCommand("warp test");
                            }
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Spawn")) {
                                Player p = (Player) e.getWhoClicked();
                                p.performCommand("warp spawn");
                            }
                            break;
                        case RED_CONCRETE:
                            e.getWhoClicked().sendMessage(ChatColor.RED + "Je kunt alleen naar een attractie warpen zodra die geopend is");
                            break;
                        default:
                            break;
                    }
                }
                if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Freefall - Operator")) {
                    e.setCancelled(true);
                    switch (e.getCurrentItem().getType()) {
                        case GREEN_CONCRETE:
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Status")) {
                                FreefallUpdater.rideStatus = false;
                            }
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Poortjes")) {
                                FreefallUpdater.gates = false;
                            }
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Vrijgeven")) {
                                Freefall.startProgram();
                            }
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Beugels")) {
                                FreefallUpdater.restraints = false;
                            }
                            break;
                        case RED_CONCRETE:
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Status")) {
                                FreefallUpdater.rideStatus = true;
                            }
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Poortjes")) {
                                FreefallUpdater.gates = true;
                            }
                            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GOLD + "Beugels")) {
                                FreefallUpdater.restraints = true;
                            }
                            break;
                        default:
                            break;
                    }
                }
                if (e.getView().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Test Shop")) {
                    e.setCancelled(true);
                    Player p = (Player) e.getWhoClicked();
                    switch (e.getCurrentItem().getType()) {
                        case GRASS_BLOCK:
                            if (!Equipment.heeftEquipment("Grass", p)) {
                                if (Coins.getCoins(p) > 4) {
                                    Coins.setCoins(p, Coins.getCoins(p) - 5);
                                    p.getInventory().addItem(new ItemStack(Material.GRASS_BLOCK, 1));
                                    Equipment.geefEquipment("Grass", p);
                                    p.sendMessage(ChatColor.GREEN + "Je hebt een grasblok gekocht voor 5 coins");
                                } else {
                                    p.sendMessage(ChatColor.RED + "Je hebt te weinig coins");
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "Je hebt dit item al");
                            }
                            break;
                        case DIRT:
                            if (!Equipment.heeftEquipment("Dirt", p)) {
                                if (Coins.getCoins(p) > 4) {
                                    Coins.setCoins(p, Coins.getCoins(p) - 5);
                                    p.getInventory().addItem(new ItemStack(Material.DIRT, 1));
                                    Equipment.geefEquipment("Dirt", p);
                                    p.sendMessage(ChatColor.GREEN + "Je hebt een dirtblok gekocht voor 5 coins");
                                } else {
                                    p.sendMessage(ChatColor.RED + "Je hebt te weinig coins");
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "Je hebt dit item al");
                            }
                            break;
                        case STONE:
                            if (!Equipment.heeftEquipment("Stone", p)) {
                                if (Coins.getCoins(p) > 9) {
                                    Coins.setCoins(p, Coins.getCoins(p) - 10);
                                    p.getInventory().addItem(new ItemStack(Material.STONE, 1));
                                    Equipment.geefEquipment("Stone", p);
                                    p.sendMessage(ChatColor.GREEN + "Je hebt een stoneblok gekocht voor 10 coins");
                                } else {
                                    p.sendMessage(ChatColor.RED + "Je hebt te weinig coins");
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + "Je hebt dit item al");
                            }
                            break;
                        default:
                            break;
                    }
                }
            }
        } else {
            e.setCancelled(false);
        }
    }
}
