package nl.roboticsmilan.project2020.Util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class SignUpdater {

    public static void updateSign(Location loc, int line, String content) {
        World world = loc.getWorld();
        Block block = world.getBlockAt(loc);

        Sign sign = (Sign) block.getState();
        sign.setLine(line, content);
        sign.update();
    }
}
