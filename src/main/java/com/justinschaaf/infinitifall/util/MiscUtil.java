package com.justinschaaf.infinitifall.util;

import com.justinschaaf.infinitifall.Infinitifall;
import com.justinschaaf.infinitifall.command.ReloadCommand;
import org.bukkit.configuration.file.FileConfiguration;

import static org.bukkit.Bukkit.getServer;

public class MiscUtil {
    private static final Infinitifall instance = Infinitifall.instance;
    private final FileConfiguration config = instance.getConfig();
    public static double tpY;
    public static double addY;
    public static double damage;
    public static boolean removeNonLiving;
    public void reload() {
        instance.saveDefaultConfig();
        instance.reloadConfig();
        tpY = config.getDouble("tpY");
        addY = config.getDouble("addY");
        damage = config.getDouble("damage");
        removeNonLiving = config.getBoolean("removeNonLiving");
    }

    public void register() {
        instance.getCommand("infinitifallreload").setExecutor(new ReloadCommand());
        getServer().getPluginManager().registerEvents(instance, instance);
    }
}
