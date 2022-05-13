package net.pullolo.Entities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;

import java.util.Random;

import static net.pullolo.Main.plugin;

public class DamageIndicator {

    public DamageIndicator(Entity e, int amount, boolean isCrit){
        Location loc = e.getLocation();
        loc.add(e.getLocation().getDirection().multiply(1));
        loc.add(0, 1, 0);

        ArmorStand armorStand = loc.getWorld().spawn(loc, ArmorStand.class, en -> {
            en.setVisible(false);
            en.setMarker(true);
        });
        armorStand.setGravity(false);

        if (isCrit){
            Random rand = new Random();
            ChatColor[] colors = new ChatColor[4];
            colors[0] = ChatColor.WHITE;
            colors[1] = ChatColor.YELLOW;
            colors[2] = ChatColor.GOLD;
            colors[3] = ChatColor.RED;

            String am = "✧" + amount + "✧";
            String changed = "";
            for (char c:am.toCharArray()) {
                changed += "" + colors[rand.nextInt(4)] + c;
            }
            armorStand.setCustomName(changed);
        } else {
            armorStand.setCustomName("§7" + amount);
        }
        armorStand.setCustomNameVisible(true);

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            armorStand.remove();
        }, 20);
    }

}
