package net.pullolo.events;

import net.pullolo.items.Items;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import static net.pullolo.Entities.EntityConverter.entities;
import static net.pullolo.stats.Stats.*;

public class EntityListener implements Listener {

    @EventHandler
    public void onEntityDamagedByEntity(EntityDamageByEntityEvent e){
        if (entityMap.containsKey(e.getEntity())){
            if (e.getDamager() instanceof Player){
                if (((Player) e.getDamager()).getInventory().getItemInMainHand().getItemMeta() != null){
                    if (((Player) e.getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(Items.Aspect_of_end.getItemMeta().getDisplayName())){
                        entityMap.get(e.getEntity()).dealDamage(itemsMap.get(Items.Aspect_of_end).getDamage());
                        return;
                    }
                    if (((Player) e.getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(Items.Aspect_of_dragons.getItemMeta().getDisplayName())){
                        entityMap.get(e.getEntity()).dealDamage(itemsMap.get(Items.Aspect_of_dragons).getDamage());
                        return;
                    }
                    if (((Player) e.getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(Items.Leaping_sword.getItemMeta().getDisplayName())){
                        entityMap.get(e.getEntity()).dealDamage(itemsMap.get(Items.Leaping_sword).getDamage());
                        return;
                    }
                    if (((Player) e.getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(Items.Hyperion.getItemMeta().getDisplayName())){
                        entityMap.get(e.getEntity()).dealDamage(itemsMap.get(Items.Hyperion).getDamage());
                        return;
                    }
                    if (((Player) e.getDamager()).getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(Items.Healing_wand.getItemMeta().getDisplayName())){
                        entityMap.get(e.getEntity()).dealDamage(itemsMap.get(Items.Healing_wand).getDamage());
                        return;
                    }
                }
            }
            if (entities.contains(e.getDamager())){
                if (!(e.getDamager() instanceof Player)){
                    entityMap.get(e.getEntity()).dealDamage(entityMap.get(e.getDamager()).getDamage());
                }
                else entityMap.get(e.getEntity()).dealDamage((int) (entityMap.get(e.getDamager()).getDamage() + e.getDamage()));
            }
            else entityMap.get(e.getEntity()).dealDamage((int) e.getDamage());
        }
    }

    @EventHandler
    public void onEntityDamagedBySomethingElse(EntityDamageEvent e){
        if (e instanceof EntityDamageByEntityEvent){
            return;
        }
        if (entityMap.containsKey(e.getEntity())){
            entityMap.get(e.getEntity()).dealDamage((int) e.getDamage());
        }
    }
}
