package com.justinschaaf.infinitifall;

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

    private double damage = 4.0;
    private double addY = 182.0;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        damage = getConfig().getDouble("damage", 4.0);
        addY = getConfig().getDouble("addY", 4.0);

        getServer().getPluginManager().registerEvents(this, this);

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

        if (e.getLocation().getY() < 0) {

            e.teleport(e.getLocation().add(0, addY, 0));

            EntityDamageEvent voidDamage = new EntityDamageEvent(e, EntityDamageEvent.DamageCause.VOID, damage);
            getServer().getPluginManager().callEvent(voidDamage);

            if (!voidDamage.isCancelled()) {

                if (e instanceof LivingEntity) ((LivingEntity) e).damage(voidDamage.getDamage());
                else e.remove();

                e.setLastDamageCause(voidDamage);

            }

        }

    }

}
