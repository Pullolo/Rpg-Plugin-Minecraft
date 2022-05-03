package net.pullolo.events;

import static net.pullolo.stats.Stats.manaMap;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Bukkit.broadcastMessage("[Server]: F in the chat for " + event.getEntity().getName());
        try{
            manaMap.get(event.getEntity()).setMana(manaMap.get(event.getEntity()).getMaxMana());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
