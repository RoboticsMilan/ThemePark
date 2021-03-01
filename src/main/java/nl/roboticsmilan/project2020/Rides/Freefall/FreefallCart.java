package nl.roboticsmilan.project2020.Rides.Freefall;

import nl.roboticsmilan.project2020.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

public class FreefallCart {

    public static ArmorStand spawnCart(String name, int id, short model, Location spawn) {
        ArmorStand cart = (ArmorStand) Main.getWorld().spawnEntity(spawn, EntityType.ARMOR_STAND);
        cart.setCustomName(name+"_C"+id);
        cart.setCustomNameVisible(false);
        cart.setGravity(false);
        cart.setVisible(false);
        ItemStack modelItem = new ItemStack(Material.DIAMOND_SWORD, 1);
        modelItem.setDurability(model);
        cart.setHelmet(modelItem);
        return cart;
    }

    public static ArmorStand spawnSeat(String name, Location spawn) {
        ArmorStand seat = (ArmorStand) Main.getWorld().spawnEntity(spawn, EntityType.ARMOR_STAND);
        seat.setGravity(false);
        seat.setCustomName(name+"_SEAT");
        seat.setCustomNameVisible(false);
        seat.setVisible(false);
        return seat;
    }
}
