package com.justinschaaf.infinitifall;

public class Config {

    public static double tpY;
    public static double addY;
    public static double damage;
    public static boolean removeNonLiving;

    public static String msgErrorNoPerms;
    public static String msgErrorUnknownCmd;
    public static String msgReloadConfirmed;
    public static String msgReloadErrored;

    public static void load(Infinitifall plugin) {

        plugin.saveDefaultConfig();
        plugin.reloadConfig();

        tpY = plugin.getConfig().getDouble("tpY", -64.0);
        addY = plugin.getConfig().getDouble("addY", 246.0);
        damage = plugin.getConfig().getDouble("damage", 4.0);
        removeNonLiving = plugin.getConfig().getBoolean("removeNonLiving", true);

        msgErrorNoPerms = plugin.getConfig().getString("messages.errorNoPerms", "&4You don't have permission to execute this command.");
        msgErrorUnknownCmd = plugin.getConfig().getString("message.errorUnknownCmd", "&4Unknown command. Usage: /infinitifall (reload)");
        msgReloadConfirmed = plugin.getConfig().getString("messages.reloadConfirmed", "&aInfinitifall reloaded.");
        msgReloadErrored = plugin.getConfig().getString("messages.reloadErrored", "&4Something went wrong reloading Infinitifall, see the console for more details.");

    }

}
