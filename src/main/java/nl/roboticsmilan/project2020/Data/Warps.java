package nl.roboticsmilan.project2020.Data;

import nl.roboticsmilan.project2020.Main;
import org.bukkit.Location;

public enum Warps {

    SPAWN("spawn", new Location(Main.getWorld(), -2, 5, 32, 0, 0)),
    DORP("dorp", new Location(Main.getWorld(), -192 , 4, -217, 0, 0)),
    DROPTOWER("droptower", new Location(Main.getWorld(), -194, 4, 82, 0, 0)),
    TESTATTRACTIE("test", new Location(Main.getWorld(), 14, 4, 38, -90, 0));

    private String name;
    private Location loc;

    private Warps(String name, Location loc) {
        this.name = name;
        this.loc = loc;
    }

    public String getName() {
        return name;
    }

    public Location getLoc() {
        return loc;
    }
}
