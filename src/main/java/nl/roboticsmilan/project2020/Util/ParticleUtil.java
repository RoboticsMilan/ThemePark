package nl.roboticsmilan.project2020.Util;

import org.apache.commons.lang.Validate;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class ParticleUtil {

    public static void spawnParticle(Particle particle, Location loc, double x, double y, double z, int amount, int speed) {
        loc.getWorld().spawnParticle(particle, loc, amount, x, y, z, speed);
    }

    public static void spawnLaser(Location basis, Location target, Color color) {
        World world = basis.getWorld();
        Validate.isTrue(target.getWorld().equals(world));
        double dis = basis.distance(target);
        Vector position1 = basis.toVector();
        Vector position2 = target.toVector();

        Vector vector = position2.clone().subtract(position1).normalize().multiply(0.1);
        double cover = 0;
        for (; cover < dis; position1.add(vector)) {
            Particle.DustOptions dustOptions = new Particle.DustOptions(color, 1);
            world.spawnParticle(Particle.REDSTONE, position1.getX(), position1.getY(), position1.getZ(), 1, dustOptions);
            cover += 0.1;
        }
    }

}
