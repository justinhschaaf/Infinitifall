package com.justinschaaf.infinitifall;

import org.bukkit.plugin.java.JavaPlugin;

public final class Infinitifall extends JavaPlugin {

    @Override
    public void onEnable() {

        Config.load(this);

        getServer().getPluginManager().registerEvents(new Circumnavigator(), this);
        getCommand("infinitifall").setExecutor(new CommandHandler(this));

    }

}