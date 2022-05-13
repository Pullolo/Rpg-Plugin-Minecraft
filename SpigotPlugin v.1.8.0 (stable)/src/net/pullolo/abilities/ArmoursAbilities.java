package net.pullolo.abilities;

import net.pullolo.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Objects;

public class ArmoursAbilities extends BukkitRunnable {

    @Override
    public void run() {
        List<Player> players = (List<Player>) Bukkit.getOnlinePlayers();
        for (Player player : players){
            if (player.getInventory().getHelmet() != null &&
                    player.getInventory().getChestplate() != null &&
                    player.getInventory().getLeggings() != null &&
                    player.getInventory().getBoots() != null)
            {
                if (Objects.requireNonNull(player.getInventory().getHelmet().getItemMeta()).getDisplayName().equals(Items.Speed_Helmet.getItemMeta().getDisplayName()) &&
                        Objects.requireNonNull(player.getInventory().getChestplate().getItemMeta()).getDisplayName().equals(Items.Speed_Chestplate.getItemMeta().getDisplayName()) &&
                        Objects.requireNonNull(player.getInventory().getLeggings().getItemMeta()).getDisplayName().equals(Items.Speed_Leggings.getItemMeta().getDisplayName()) &&
                        Objects.requireNonNull(player.getInventory().getBoots().getItemMeta()).getDisplayName().equals(Items.Speed_Boots.getItemMeta().getDisplayName()))
                {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 2));
                }
            }
        }
    }
}

