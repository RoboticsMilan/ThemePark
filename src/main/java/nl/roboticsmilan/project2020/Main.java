package nl.roboticsmilan.project2020;

import nl.roboticsmilan.project2020.Commands.*;
import nl.roboticsmilan.project2020.Events.*;
import nl.roboticsmilan.project2020.GUI.FreefallMenu;
import nl.roboticsmilan.project2020.GUI.RideMenu;
import nl.roboticsmilan.project2020.Rides.Freefall.Freefall;
import nl.roboticsmilan.project2020.Rides.Freefall.FreefallHandler;
import nl.roboticsmilan.project2020.Rides.Freefall.FreefallUpdater;
import nl.roboticsmilan.project2020.Tasks.CoinTimer;
import nl.roboticsmilan.project2020.Tasks.ParticleTask;
import nl.roboticsmilan.project2020.Tasks.Scoreboard;
import nl.roboticsmilan.project2020.Tasks.SignUpdateTask;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static Plugin plugin;

    public static World getWorld() {
        return Bukkit.getWorld("world");
    }

    @Override
    public void onEnable() {
        plugin = this;
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinEvent(), this);
        pm.registerEvents(new LeaveEvent(), this);
        pm.registerEvents(new InventoryEvent(), this);
        pm.registerEvents(new MoveEvent(), this);
        pm.registerEvents(new ChatEvent(), this);
        pm.registerEvents(new SeatEvent(), this);
        pm.registerEvents(new ExitSeatEvent(), this);
        getCommand("hallo").setExecutor(new HalloCommand());
        getCommand("economy").setExecutor(new EconomyCommand());
        getCommand("profile").setExecutor(new ProfileCommand());
        getCommand("ride").setExecutor(new RideCommand());
        getCommand("warp").setExecutor(new WarpCommand());
        getCommand("achievement").setExecutor(new AchievementCommand());
        getCommand("ridecounter").setExecutor(new RidecounterCommand());
        getCommand("chat").setExecutor(new ChatCommand());
        getCommand("freefall").setExecutor(new FreefallCommand());
        getCommand("shop").setExecutor(new ShopCommand());
        new CoinTimer();
        new SignUpdateTask();
        new ParticleTask();
        new Freefall();
        new FreefallHandler();
        new FreefallUpdater();
        new FreefallMenu();
        RideMenu.update();
        repairScoreboard();
    }

    private void repairScoreboard() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            Scoreboard.setupScoreboard(p);
        }
    }

    @Override
    public void onDisable() {
        plugin = null;
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
