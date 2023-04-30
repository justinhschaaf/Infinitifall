package com.justinschaaf.infinitifall;

import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class Circumnavigator implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void onEntityMove(EntityMoveEvent e) {
        doCircumnavigation(e.getEntity());
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerMove(PlayerMoveEvent e) {
        doCircumnavigation(e.getPlayer());
    }

    public static void doCircumnavigation(Entity e) {

        if (e.getLocation().getY() < Config.tpY) {

            if (Util.isPaper())
                e.teleportAsync(e.getLocation().add(0, Config.addY, 0));
            else e.teleport(e.getLocation().add(0, Config.addY, 0));

            EntityDamageEvent voidDamage = new EntityDamageEvent(e, EntityDamageEvent.DamageCause.VOID, Config.damage);
            Bukkit.getServer().getPluginManager().callEvent(voidDamage);

            if (!voidDamage.isCancelled()) {

                if (e instanceof LivingEntity) ((LivingEntity) e).damage(voidDamage.getDamage());
                else if (Config.removeNonLiving) e.remove();

                e.setLastDamageCause(voidDamage);

            }

        }

    }

}
