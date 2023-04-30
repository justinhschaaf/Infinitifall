package com.justinschaaf.infinitifall;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Util {

    private static Boolean isPaper = null;
    public static boolean isPaper() {

        if (isPaper == null)
            isPaper = tryTeleportAsync();

        return isPaper;

    }

    private static boolean tryTeleportAsync() {

        try {
            Class.forName("org.bukkit.entity.Entity").getMethod("teleportAsync", Location.class);
            return true;
        } catch (ClassNotFoundException | NoSuchMethodException ignored) {
            Bukkit.getLogger().warning("This server does not support the Paper API, which may prevent Infinitifall from functioning properly!");
            return false;
        }

    }

}
