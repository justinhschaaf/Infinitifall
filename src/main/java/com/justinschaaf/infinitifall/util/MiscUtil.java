package com.justinschaaf.infinitifall.util;

import com.justinschaaf.infinitifall.Infinitifall;
import org.bukkit.event.Listener;

public class MiscUtil implements Listener {
    private static final Infinitifall instance = Infinitifall.instance;
    public static double tpY;
    public static double addY;
    public static double damage;
    public static boolean removeNonLiving;
    public static void reload() {
        instance.saveDefaultConfig();
        instance.reloadConfig();
        tpY = instance.getConfig().getDouble("tpY");
        addY = instance.getConfig().getDouble("addY");
        damage = instance.getConfig().getDouble("damage");
        removeNonLiving = instance.getConfig().getBoolean("removeNonLiving");
    }
}
