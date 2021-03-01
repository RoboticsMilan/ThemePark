package nl.roboticsmilan.project2020.Rides.Freefall;

import nl.roboticsmilan.project2020.Main;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_15_R1.entity.CraftEntity;
import org.bukkit.entity.ArmorStand;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class Freefall {

    public static ArrayList<ArmorStand> tower1 = new ArrayList<>();
    public static ArrayList<ArmorStand> tower2 = new ArrayList<>();
    public static ArrayList<ArmorStand> tower3 = new ArrayList<>();
    public static ArrayList<ArmorStand> tower4 = new ArrayList<>();
    private static double speed;
    private static int ticks;
    private static boolean reset = false;
    private static double defaultHeight = 5.3;

    public Freefall() {
        tower1.add(FreefallCart.spawnCart("Freefall", 1, (short) 15, new Location(Main.getWorld(), -167.5, 5.3, 99.1, 180, 0)));
        tower1.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -168.5, 3.8, 99.1, 180, 0)));
        tower1.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -167.5, 3.8, 99.1, 180, 0)));
        tower1.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -166.5, 3.8, 99.1, 180, 0)));
        tower2.add(FreefallCart.spawnCart("Freefall", 2, (short) 15, new Location(Main.getWorld(), -170, 5.3, 101.5, 90, 0)));
        tower2.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -170, 3.8, 100.5, 90, 0)));
        tower2.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -170, 3.8, 101.5, 90, 0)));
        tower2.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -170, 3.8, 102.5, 90, 0)));
        tower3.add(FreefallCart.spawnCart("Freefall", 3, (short) 15, new Location(Main.getWorld(), -167.5, 5.3, 103.9, 0, 0)));
        tower3.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -168.5, 3.8, 103.9, 0, 0)));
        tower3.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -167.5, 3.8, 103.9, 0, 0)));
        tower3.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -166.5, 3.8, 103.9, 0, 0)));
        tower4.add(FreefallCart.spawnCart("Freefall", 4, (short) 15, new Location(Main.getWorld(), -165.1, 5.3, 101.5, -90, 0)));
        tower4.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -165.1, 3.8, 100.5, -90, 0)));
        tower4.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -165.1, 3.8, 101.5, -90, 0)));
        tower4.add(FreefallCart.spawnSeat("Freefall", new Location(Main.getWorld(), -165.1, 3.8, 102.5, -90, 0)));
        defaultHeight = 5.3;
        reset = false;
        ticks = 0;
        speed = 0.0;
    }

    public static void moveStands(ArrayList<ArmorStand> stands, int yaw) {
        for (ArmorStand stand : stands) {
            Location loc = stand.getLocation();
            loc.setYaw(yaw);
            stand.setGravity(false);
            CraftEntity ent = (CraftEntity) stand;
            if (!reset) {
                ent.getHandle().setPositionRotation(loc.getX(), loc.getY()+speed, loc.getZ(), loc.getYaw(), loc.getPitch());
            } else {
                if (!stand.getCustomName().endsWith("SEAT")) {
                    ent.getHandle().setPositionRotation(loc.getX(), defaultHeight, loc.getZ(), loc.getYaw(), loc.getPitch());
                } else {
                    ent.getHandle().setPositionRotation(loc.getX(), 3.9, loc.getZ(), loc.getYaw(), loc.getPitch());
                }
            }

        }
    }

    public static void startProgram() {
        FreefallHandler.dispatched = true;
        new BukkitRunnable() {
            @Override
            public void run() {
                ticks++;
                moveStands(tower1, 180);
                moveStands(tower2, 90);
                moveStands(tower3, 0);
                moveStands(tower4, -90);
                if (ticks == 1) {
                    addSpeed(0.02, 0.1);
                }
                if (ticks == 245) {
                    removeSpeed(0.02, 0);
                }
                if (ticks == 300) {
                    removeSpeed(0.05, -1);
                }
                if (ticks == 323) {
                    addSpeed(0.05, -0.05);
                }
                if (ticks == 465) {
                    addSpeed(0.01, 0);
                }
                if (ticks == 470) {
                    reset = true;
                }
                if (ticks == 475) {
                    reset = false;
                }
                if (ticks == 480) {
                    defaultHeight = 5.3;
                    reset = false;
                    ticks = 0;
                    speed = 0.0;
                    FreefallHandler.dispatched = false;
                    for (ArmorStand stand : tower1) {
                        if (stand.getPassenger() != null) {
                            stand.removePassenger(stand.getPassenger());
                        }
                    }
                    for (ArmorStand stand : tower2) {
                        if (stand.getPassenger() != null) {
                            stand.removePassenger(stand.getPassenger());
                        }
                    }
                    for (ArmorStand stand : tower3) {
                        if (stand.getPassenger() != null) {
                            stand.removePassenger(stand.getPassenger());
                        }
                    }
                    for (ArmorStand stand : tower4) {
                        if (stand.getPassenger() != null) {
                            stand.removePassenger(stand.getPassenger());
                        }
                    }
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 1L);
    }

    private static void addSpeed(double pertick, double max) {
        new BukkitRunnable() {
            @Override
            public void run() {
                speed += pertick;
                if (speed > max) {
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 1L);
    }

    private static void removeSpeed(double pertick, double min) {
        new BukkitRunnable() {
            @Override
            public void run() {
                speed -= pertick;
                if (speed < min) {
                    cancel();
                }
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 1L);
    }
}
