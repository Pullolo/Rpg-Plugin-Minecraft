package net.pullolo.stats;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.pullolo.Entities.EntityConverter;
import net.pullolo.abilities.ItemAbilities;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Display extends BukkitRunnable {
    @Override
    public void run() {
        for (Entity e:EntityConverter.entities) {
            if (e != null){
                if (e instanceof Player){
                    Player p = (Player) e;
                    try{
                        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§c" + Stats.entityMap.get(p).getHealth() + "/" + Stats.entityMap.get(p).getMaxHealth()
                                + "❤     §a" + (Stats.entityMap.get(p).getDefense() + Stats.entityMap.get(p).getBonusDefense()) + "❈ Defense    §b" + Stats.manaMap.get(p).getMana()
                                + "/" + Stats.manaMap.get(p).getMaxMana() + "✎ Mana"));
                    } catch (Exception exception){
                        exception.printStackTrace();
                    }
                }
            }
        }
    }
}
