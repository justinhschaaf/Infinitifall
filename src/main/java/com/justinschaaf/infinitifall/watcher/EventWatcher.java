package com.justinschaaf.infinitifall.watcher;

import com.justinschaaf.infinitifall.util.HandleUtil;
import com.justinschaaf.infinitifall.util.MiscUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import static com.justinschaaf.infinitifall.util.MiscUtil.damage;
import static com.justinschaaf.infinitifall.util.MiscUtil.removeNonLiving;
import static org.bukkit.Bukkit.getServer;

public class EventWatcher implements Listener {
    public static void doCircumnavigation(Entity e) {
        if (e.getLocation().getY() < MiscUtil.tpY) {
            if (HandleUtil.isPaperFolia()) {

                e.teleportAsync(e.getLocation().add(0, MiscUtil.addY, 0));

            } else {

                e.teleport(e.getLocation().add(0, MiscUtil.addY, 0));

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
