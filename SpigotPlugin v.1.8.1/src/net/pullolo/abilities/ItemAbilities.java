package net.pullolo.abilities;

import net.pullolo.Entities.EntityConverter;
import net.pullolo.stats.Mana;
import net.pullolo.items.Items;
import org.bukkit.*;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.pullolo.stats.EntityStats;

import static net.pullolo.stats.Stats.*;


import java.util.Collection;
import java.util.List;

//import static net.pullolo.stats.Stats.manaMap;
import static org.bukkit.Bukkit.getOnlinePlayers;
import static org.bukkit.Bukkit.getServer;

public class ItemAbilities extends BukkitRunnable implements Listener{


    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            Player player = event.getPlayer();
            if (event.getItem() != null && event.getItem().getItemMeta().getLore() != null) {

                if (event.getItem().getItemMeta().getDisplayName().equals(Items.Aspect_of_end.getItemMeta().getDisplayName())) {
                    if(manaMap.get(player).getMana() >= itemsMap.get(Items.Aspect_of_end).getManaCost()){
                        manaMap.get(player).setMana(manaMap.get(player).getMana()-itemsMap.get(Items.Aspect_of_end).getManaCost());
                        player.sendMessage( ChatColor.BLUE + "You have " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                        Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                        if (player.getWorld().getBlockAt(loc.add(loc.getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER)) {
                            player.teleport(loc);
                        }
                        else player.sendMessage(ChatColor.RED + "There are blocks in the way!");
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1f, 1f);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 1));

                        for (int i = 0; i < itemsMap.get(Items.Aspect_of_end).getAbilityPower(); i++) {
                            if (player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER)) {
                                player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(1)));
                            }
                        }
                    }
                    else player.sendMessage(ChatColor.RED + "You dont have enough Mana! " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                }


                if (event.getItem().getItemMeta().getDisplayName().equals(Items.Aspect_of_dragons.getItemMeta().getDisplayName())) {
                    if(manaMap.get(player).getMana() >= itemsMap.get(Items.Aspect_of_dragons).getManaCost()){
                        manaMap.get(player).setMana(manaMap.get(player).getMana()-itemsMap.get(Items.Aspect_of_dragons).getManaCost());
                        player.sendMessage( ChatColor.BLUE + "You have " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                        player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1f, 1f);

                        Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1.5, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                        for (Player p: getOnlinePlayers()) {
                            for (int i = 10; i<19; i++){
                                p.spawnParticle(Particle.FLAME, loc.add(player.getLocation().getDirection().multiply(0.1 * i)), 10, 0.02 * i, 0.02 * i, 0.02 * i, 0.1);
                            }
                        }

                        List<Entity> nearbyEntites = (List<Entity>) getServer().getWorld(player.getWorld().getName()).getNearbyEntities(player.getLocation().add(player.getLocation().getDirection().multiply(4)), 5, 5, 5);
                        for (Entity entity : nearbyEntites){
                            if (!(entity.equals(event.getPlayer()))) {
                                if (entity instanceof Damageable) {
//                                    ((Damageable) entity).damage(itemsMap.get(event.getItem()).getAbilityPower(), player);
                                    if (entityMap.containsKey(entity)){
                                        entityMap.get(entity).dealDamage(entity, itemsMap.get(Items.Aspect_of_dragons).getAbilityPower(), true);
                                        entity.setVelocity(player.getLocation().getDirection().multiply(3));
                                    }
                                }
                            }
                        }
                    }
                    else player.sendMessage(ChatColor.RED + "You dont have enough Mana! " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                }

                if (event.getItem().getItemMeta().getDisplayName().equals(Items.Leaping_sword.getItemMeta().getDisplayName())) {
                    if(!CooldownAPI.isOnCooldown("LS", player)){
                        if(manaMap.get(player).getMana() >= itemsMap.get(Items.Leaping_sword).getManaCost()){
                            manaMap.get(player).setMana(manaMap.get(player).getMana()-itemsMap.get(Items.Leaping_sword).getManaCost());
                            player.sendMessage( ChatColor.BLUE + "You have " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                            player.playSound(player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
                            player.setVelocity(player.getLocation().getDirection().multiply(2.8));
                            List<Entity> nearbyEntites = (List<Entity>) getServer().getWorld(player.getWorld().getName()).getNearbyEntities(player.getLocation(), 8, 6, 8);

                            for (Player p: getOnlinePlayers()) {
                                p.spawnParticle(Particle.EXPLOSION_HUGE, (player.getLocation()), 4, 0.2, 0.1, 0.2, 0.3);
                                p.spawnParticle(Particle.FLAME, (player.getLocation()), 100, 0.6, 0.6, 0.6, 0.2);
                            }

                            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 100, 255));

                            for (Entity entity : nearbyEntites){
                                if (!(entity.equals(event.getPlayer()))) {
                                    if (entity instanceof Damageable) {
                                        if (entityMap.containsKey(entity)){
                                            entityMap.get(entity).dealDamage(entity, itemsMap.get(Items.Leaping_sword).getAbilityPower(), true);
//                                        ((Damageable) entity).damage(itemsMap.get(event.getItem()).getAbilityPower(), player);
                                        }
                                    }
                                }
                            }
                            CooldownAPI.addCooldown("LS", player, 10);
                        }
                        else player.sendMessage(ChatColor.RED + "You dont have enough Mana! " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                    }
                    else player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("LS", player) + "s.");
                }

                if (event.getItem().getItemMeta().getDisplayName().equals(Items.Hyperion.getItemMeta().getDisplayName())) {
                    if(manaMap.get(player).getMana() >= itemsMap.get(Items.Hyperion).getManaCost()){
                        manaMap.get(player).setMana(manaMap.get(player).getMana() - itemsMap.get(Items.Hyperion).getManaCost());
                        player.sendMessage( ChatColor.BLUE + "You have " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                        player.playSound(player.getLocation(), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1f, 1f);
                        Location loc = new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY() + 1, player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                        if (player.getWorld().getBlockAt(loc.add(loc.getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER)) {
                            player.teleport(loc);
                        }
                        else player.sendMessage(ChatColor.RED + "There are blocks in the way!");
                        player.playSound(player.getLocation(), Sound.ENTITY_WITHER_AMBIENT, 1f, 1f);

                        for (int i = 0; i < 10; i++) {
                            if (player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.AIR) || player.getWorld().getBlockAt(player.getLocation().add(player.getLocation().getDirection().multiply(1))).getBlockData().getMaterial().equals(Material.WATER)) {
                                player.teleport(player.getLocation().add(player.getLocation().getDirection().multiply(1)));
                            }
                        }
                        List<Entity> nearbyEntites = (List<Entity>) getServer().getWorld(player.getWorld().getName()).getNearbyEntities(player.getLocation(), 8, 6, 8);
                        for (Entity entity : nearbyEntites){
                            if (!(entity.equals(event.getPlayer()))) {
                                if (entity instanceof Damageable) {
                                    if (entityMap.containsKey(entity)){
                                        entityMap.get(entity).dealDamage(entity, itemsMap.get(Items.Hyperion).getAbilityPower(), true);
//                                    ((Damageable) entity).damage(itemsMap.get(event.getItem()).getAbilityPower(), player);
                                    }
                                }
                            }
                        }

                        for (Player p: Bukkit.getOnlinePlayers()) {
                            p.spawnParticle(Particle.EXPLOSION_HUGE, (player.getLocation().add(player.getLocation().getDirection().multiply(-3))), 4, 0.2, 0.1, 0.2, 0.3);
                            p.spawnParticle(Particle.FLAME, (player.getLocation().add(player.getLocation().getDirection().multiply(-3))), 100, 0.6, 0.6, 0.6, 0.2);
                        }

                        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 40, 2));
                        Thread abs = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                int prev = entityMap.get(player).getBaseDefense();
                                entityMap.get(player).setDefense(prev+5);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                entityMap.get(player).setDefense(prev);
                            }
                        });
                        abs.start();
                    }
                    else player.sendMessage(ChatColor.RED + "You dont have enough Mana! " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                }

                if (event.getItem().getItemMeta().getDisplayName().equals(Items.Healing_wand.getItemMeta().getDisplayName())) {
                    if (!CooldownAPI.isOnCooldown("HW", player)) {
                        if (manaMap.get(player).getMana() >= itemsMap.get(Items.Healing_wand).getManaCost()){
                            manaMap.get(player).setMana(manaMap.get(player).getMana() - itemsMap.get(Items.Healing_wand).getManaCost());
                            player.sendMessage( ChatColor.BLUE + "You have " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                            Thread regen = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    entityMap.get(player).setBonusHealthRegen(3*entityMap.get(player).getLevel());
                                    try {
                                        Thread.sleep(5000);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    entityMap.get(player).setBonusHealthRegen(0);
                                }
                            });
                            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, itemsMap.get(Items.Healing_wand).getAbilityPower()));
                            regen.start();
                            CooldownAPI.addCooldown("HW", player, 10);
                        }
                        else player.sendMessage(ChatColor.RED + "You dont have enough Mana! " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
                    }
                    else player.sendMessage(ChatColor.RED + "This item is on Cooldown for " + CooldownAPI.getCooldownForPlayerInt("HW", player) + "s.");
                }
            }
        }
    }

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event){
        manaMap.put(event.getPlayer(), new Mana());
    }

    @EventHandler
    public static void onPlayerLeave(PlayerQuitEvent event){
        manaMap.remove(event.getPlayer());
        EntityConverter.entities.remove(event.getPlayer());
        entityMap.remove(event.getPlayer());
    }

    @Override
    public void run() {
        Collection<Mana> manas = manaMap.values();
        Collection<EntityStats> entities = entityMap.values();
        for (Mana mana : manas) {
            mana.RegenMana();
        }
        for (EntityStats entity:entities) {
            entity.regen();
        }
    }
}
