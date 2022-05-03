package net.pullolo;

import net.pullolo.Entities.EntityConverter;
import net.pullolo.abilities.ArmoursAbilities;
import net.pullolo.commands.*;
import net.pullolo.abilities.CooldownAPI;
import net.pullolo.events.DeathListener;
import net.pullolo.abilities.ItemAbilities;
import net.pullolo.events.EntityListener;
import net.pullolo.events.Mana;
import net.pullolo.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

import static net.pullolo.stats.Stats.manaMap;

public class Main extends JavaPlugin {

    public static final String prefix = ChatColor.GREEN + "[RpgWam]: ";

    @Override
    public void onEnable() {
        Items.init();
        Commands cmds = new Commands();
        Set set = new Set();;

        getCommand("hi").setExecutor(cmds);
        getCommand("bye").setExecutor(cmds);
        getCommand("set").setExecutor(set);
        getCommand("mana").setExecutor(set);

        getCommand("max").setExecutor(new Max());
        getCommand("heal").setExecutor(new Heal());
        getCommand("sudo").setExecutor(new Sudo());

        getCommand("giveitem").setExecutor(new GiveCustomItems());
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new ItemAbilities(), this);
        getServer().getPluginManager().registerEvents(new EntityListener(), this);
        createPlayersManas();
        getServer().getConsoleSender().sendMessage(prefix +"Plugin Enabled!");

        ArmoursAbilities armoursAbilities = new ArmoursAbilities();
        armoursAbilities.runTaskTimer(this, 0, 10);
        EntityConverter entityConverter = new EntityConverter();
        entityConverter.runTaskTimer(this, 0, 1);
        ItemAbilities abilities = new ItemAbilities();
        abilities.runTaskTimer(this, 0, 20);
        createCooldowns();
    }


    private void createPlayersManas(){
        Collection<Player> players = (Collection<Player>) Bukkit.getOnlinePlayers();
        for (Player player: players){
            manaMap.put(player, new Mana());
        }
    }

    private void createCooldowns(){
        CooldownAPI.createCooldown("LS", 10);
        CooldownAPI.createCooldown("HW", 10);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(prefix + "Plugin Disabled!");
        for(Entity e:EntityConverter.entities){
            e.setCustomName("");
            e.setCustomNameVisible(false);
        }
    }
}