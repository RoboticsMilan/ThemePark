package nl.roboticsmilan.project2020.Data;

import nl.roboticsmilan.project2020.Main;
import nl.roboticsmilan.project2020.Util.Cuboid;
import org.bukkit.Location;

public enum Region {

    HUISHANS("Huis van Hans", new Location(Main.getWorld(), -199, 4, -227), new Location(Main.getWorld(), -201, 9, -229), true),
    VISBOERHENK("Visboer Henk", new Location(Main.getWorld(), -199, 4, -243), new Location(Main.getWorld(), -201, 9, -246), true);

    private String name;
    private Location corner1;
    private Location corner2;
    private Cuboid region;
    private boolean showname;
    private Region(String name, Location corner1, Location corner2, boolean showname) {
        this.name = name;
        this.corner1 = corner1;
        this.corner2 = corner2;
        this.showname = showname;
        region = new Cuboid(this.corner1, this.corner2);
    }

    public String getName() {
        return name;
    }

    public Cuboid getRegion() {
        return region;
    }

    public Location getCorner1() {
        return corner1;
    }

    public Location getCorner2() {
        return corner2;
    }

    public boolean canShowName() {
        return showname;
    }
}
