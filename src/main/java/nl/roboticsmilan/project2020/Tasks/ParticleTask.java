package nl.roboticsmilan.project2020.Tasks;

import nl.roboticsmilan.project2020.Main;
import nl.roboticsmilan.project2020.Util.ParticleUtil;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleTask {

    public ParticleTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                ParticleUtil.spawnParticle(Particle.CLOUD, new Location(Main.getWorld(), -203, 6, -277), 2, 2, 2, 15, 0);
                ParticleUtil.spawnLaser(new Location(Main.getWorld(), -195, 4, -280), new Location(Main.getWorld(), -192, 6, -277), Color.GREEN);
            }
        }.runTaskTimer(Main.getPlugin(), 0L, 10L);
    }
}
