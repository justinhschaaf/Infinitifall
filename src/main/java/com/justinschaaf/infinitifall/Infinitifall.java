package com.justinschaaf.infinitifall;

import com.justinschaaf.infinitifall.util.MiscUtil;
import com.justinschaaf.infinitifall.watcher.EventWatcher;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Infinitifall extends JavaPlugin implements Listener {
    public static Infinitifall instance;
    public static MiscUtil MiscUtil;
    public static EventWatcher EventWatcher;
    @Override
    public void onEnable() {

        instance = this;
        saveDefaultConfig();
        MiscUtil.register();
        MiscUtil.reload();

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityMove(EntityMoveEvent e) {
        EventWatcher.doCircumnavigation(e.getEntity());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerMove(PlayerMoveEvent e) {
        EventWatcher.doCircumnavigation(e.getPlayer());
    }

}