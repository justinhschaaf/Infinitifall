package com.justinschaaf.infinitifall;

import com.justinschaaf.infinitifall.util.HandleUtil;
import com.justinschaaf.infinitifall.util.MiscUtil;
import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Infinitifall extends JavaPlugin implements Listener {
    public static Infinitifall instance;
    public static MiscUtil MiscUtil;
    private double tpY = -64.0;
    private double addY = 182.0;
    private double damage = 4.0;
    private boolean removeNonLiving = true;

    @Override
    public void onEnable() {

        instance = this;
        saveDefaultConfig();
        MiscUtil.register();
        MiscUtil.reload();

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityMove(EntityMoveEvent e) {
        doCircumnavigation(e.getEntity());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerMove(PlayerMoveEvent e) {
        doCircumnavigation(e.getPlayer());
    }

    private void doCircumnavigation(Entity e) {
        if (e.getLocation().getY() < tpY) {
            if (HandleUtil.isPaperFolia()) {

                e.teleportAsync(e.getLocation().add(0, addY, 0));

            } else {

                e.teleport(e.getLocation().add(0, addY, 0));

            }

            EntityDamageEvent voidDamage = new EntityDamageEvent(e, EntityDamageEvent.DamageCause.VOID, damage);
            getServer().getPluginManager().callEvent(voidDamage);

            if (!voidDamage.isCancelled()) {

                if (e instanceof LivingEntity) ((LivingEntity) e).damage(voidDamage.getDamage());
                else if (removeNonLiving) e.remove();

                e.setLastDamageCause(voidDamage);

            }
        }
    }
}