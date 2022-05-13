package net.pullolo.Entities;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.pullolo.stats.EntityStats;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static net.pullolo.stats.EntityStats.MAX_PLAYER_HEALTH;
import static net.pullolo.stats.Stats.entityMap;

public class EntityConverter extends BukkitRunnable {

    public static List<Entity> entities = new ArrayList<>();

    @Override
    public void run() {
        for (World w:Bukkit.getWorlds()) {
            for (Entity e:w.getEntities()) {
                if (e instanceof Damageable && !(e instanceof ArmorStand)){
                    if (!entities.contains(e)){
                        if (e instanceof Player){
                            if (Bukkit.getServer().getOnlinePlayers().contains(e)){
                                entities.add(e);
                                entityMap.put(e, new EntityStats(e));
                            }
                        }
                        else {
                            entities.add(e);
                            entityMap.put(e, new EntityStats(e));
                        }
                    }
                }
            }
        }
        ArrayList<Entity> toDel = new ArrayList<>();
        for (Entity e:entityMap.keySet()) {
            if (entityMap.get(e).getHealth() <= 0){
                if (e instanceof Damageable){
                    if (e instanceof Player){
                        entityMap.get(e).respawn();
                        try{
                            e.teleport(((Player) e).getBedSpawnLocation());
                        } catch (Exception er){
                            try{
                                Bukkit.getServer().getWorld(e.getWorld().getName()).getSpawnLocation();
                            } catch (Exception err){
                                Bukkit.getServer().getConsoleSender().sendMessage("The player " + ((Player) e).getPlayerListName() + " couldn't respawn properly!");
                            }
                        }
                        Bukkit.broadcastMessage("[Server]: F in the chat for " + ((Player) e).getPlayerListName());
                        e.sendMessage(ChatColor.RED + "You died!");
                    }
                    else {
                        updateName(e);
                        ((Damageable) e).setHealth(0);
                        toDel.add(e);
                    }
                }
            }
        }
        for (Entity e:toDel) {
            entities.remove(e);
            entityMap.remove(e, entityMap.get(e));
        }
        for (Entity e:entities) {
            entityMap.get(e).updateStats(e);
            if (!e.getType().equals(EntityType.PLAYER)){
                updateName(e);
                ((Damageable) e).setMaxHealth(40);
                ((Damageable) e).setHealth(40);
            }
            else {
                float h = ((float) entityMap.get(e).getHealth() / (float) entityMap.get(e).getMaxHealth());
                h = h * 20;
                if (e instanceof Player){
                    ((Player) e).setFoodLevel(20);
                    ((Player) e).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 255, false, false, false));
                }
                ((Damageable) e).setMaxHealth(20);
                if (h >= 1){
                    ((Damageable) e).setHealth((int) h);
                }
                else {
                    ((Damageable) e).setHealth(1);
                }
            }
        }
    }

    private void updateName(Entity e){
        if (!(e instanceof Player)){
            entityMap.get(e).updateCustomName();
            e.setCustomName(entityMap.get(e).getCustomName());
            e.setCustomNameVisible(true);
        }
    }
}
