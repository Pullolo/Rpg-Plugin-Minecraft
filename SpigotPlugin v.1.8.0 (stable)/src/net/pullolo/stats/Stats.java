package net.pullolo.stats;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Stats {
    public static HashMap<Player, Mana> manaMap = new HashMap<>();
    public static HashMap<ItemStack, ItemStats> itemsMap = new HashMap<>();
    public static HashMap<ItemStack, ArmorStats> armorMap = new HashMap<>();
    public static HashMap<Entity, EntityStats> entityMap = new HashMap<>();
}
