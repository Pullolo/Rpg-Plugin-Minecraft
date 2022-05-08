package net.pullolo.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.pullolo.stats.ArmorStats;
import net.pullolo.stats.ItemStats;
import net.pullolo.stats.Stats;

import java.util.ArrayList;
import java.util.List;

public class Items {
    public static ItemStack Aspect_of_end;
    public static ItemStack Aspect_of_dragons;
    public static ItemStack Leaping_sword;
    public static ItemStack Hyperion;
    public static ItemStack Healing_wand;

    public static ItemStack Speed_Helmet;
    public static ItemStack Speed_Chestplate;
    public static ItemStack Speed_Leggings;
    public static ItemStack Speed_Boots;

    public static void init(){
        createAspectOfEnd();
        createAspectOfDragons();
        createLeapingSword();
        createHyperion();
        createHealingWand();
        createSpeedArmour();
    }

    private static void createSpeedArmour(){
        ItemStack helmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemMeta meta1 = helmet.getItemMeta();
        meta1.setDisplayName("§aSpeedster Helmet");
        meta1.setUnbreakable(true);
        meta1.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore1 = new ArrayList<>();

        lore1.add("");
        lore1.add("§6Full set Bonus: Zooming");
        lore1.add("§7Constantly gives you +3 §fSpeed");
        lore1.add("§7to zoom around.");
        lore1.add("");
        lore1.add("§8This item can be reforged!");
        lore1.add("§aUNCOMMON HELMET");

        meta1.setLore(lore1);
        helmet.setItemMeta(meta1);
        Speed_Helmet = helmet;

        ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemMeta meta2 = chestplate.getItemMeta();
        meta2.setDisplayName("§aSpeedster Chestplate");
        meta2.setUnbreakable(true);
        meta2.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore2 = new ArrayList<>();

        lore2.add("");
        lore2.add("§6Full set Bonus: Zooming");
        lore2.add("§7Constantly gives you +3 §fSpeed");
        lore2.add("§7to zoom around.");
        lore2.add("");
        lore2.add("§8This item can be reforged!");
        lore2.add("§aUNCOMMON CHESTPLATE");

        meta2.setLore(lore2);
        chestplate.setItemMeta(meta2);
        Speed_Chestplate = chestplate;

        ItemStack leggins = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemMeta meta3 = chestplate.getItemMeta();
        meta3.setDisplayName("§aSpeedster Leggings");
        meta3.setUnbreakable(true);
        meta3.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore3 = new ArrayList<>();

        lore3.add("");
        lore3.add("§6Full set Bonus: Zooming");
        lore3.add("§7Constantly gives you +3 §fSpeed");
        lore3.add("§7to zoom around.");
        lore3.add("");
        lore3.add("§8This item can be reforged!");
        lore3.add("§aUNCOMMON LEGGINGS");

        meta3.setLore(lore3);
        leggins.setItemMeta(meta3);
        Speed_Leggings = leggins;

        ItemStack boots = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta meta4 = boots.getItemMeta();
        meta4.setDisplayName("§aSpeedster Boots");
        meta4.setUnbreakable(true);
        meta4.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore4 = new ArrayList<>();

        lore4.add("");
        lore4.add("§6Full set Bonus: Zooming");
        lore4.add("§7Constantly gives you +3 §fSpeed");
        lore4.add("§7to zoom around.");
        lore4.add("");
        lore4.add("§8This item can be reforged!");
        lore4.add("§aUNCOMMON BOOTS");

        meta4.setLore(lore4);
        boots.setItemMeta(meta4);
        Speed_Boots = boots;

        Stats.armorMap.put(Speed_Helmet, new ArmorStats(2, 0, 10));
        Stats.armorMap.put(Speed_Chestplate, new ArmorStats(6, 0, 10));
        Stats.armorMap.put(Speed_Leggings, new ArmorStats(5, 0, 10));
        Stats.armorMap.put(Speed_Boots, new ArmorStats(2, 0, 10));
    }

    private static void createHealingWand(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aHealing Wand");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add("§6Item Ability: Small Heal §eRIGHT CLICK");
        lore.add("§7Gives you regeneration for §a5s.");
        lore.add("§8Mana Cost: §360");
        lore.add("§8Cooldown: §a10s");
        lore.add("");
        lore.add("§8This item can be reforged!");
        lore.add("§aUNCOMMON WAND");

        meta.setLore(lore);
        item.setItemMeta(meta);
        Healing_wand = item;

        Stats.itemsMap.put(Healing_wand, new ItemStats(1, 0, 60));
    }

    private static void createHyperion(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§dHyperion");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add("§6Item Ability: Wither Impact §eRIGHT CLICK");
        lore.add("§7Teleport §a10 blocks §7forward and ");
        lore.add("§7deal §a1000 §7damage to nearby enemies");
        lore.add("§7and get absorption for 2 seconds.");
        lore.add("§8Mana Cost: §3300");
        lore.add("");
        lore.add("§8This item can be reforged!");
        lore.add("§dMYTHIC SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        Hyperion = item;

        Stats.itemsMap.put(Hyperion, new ItemStats(100, 1000, 300));
    }

    private static void createLeapingSword(){
        ItemStack item = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Leaping Sword");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add("§6Item Ability: Leap §eRIGHT CLICK");
        lore.add("§7Leap into the air and deal §a50");
        lore.add("§7damage to nearby enemies.");
        lore.add("§8Mana Cost: §3100");
        lore.add("§8Cooldown: §a10s");
        lore.add("");
        lore.add("§8This item can be reforged!");
        lore.add("§5EPIC SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        Leaping_sword = item;

        Stats.itemsMap.put(Leaping_sword, new ItemStats(30, 50, 100));
    }

    private static void createAspectOfDragons(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§6Aspect of the Dragons");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add("§6Item Ability: Dragon Rage §eRIGHT CLICK");
        lore.add("§7All monsters in front of you");
        lore.add("§7take §a120. §7Hit monsters take");
        lore.add("§7large knockback.");
        lore.add("§8Mana Cost: §3100");
        lore.add("§8Cooldown: §a5s");
        lore.add("");
        lore.add("§8This item can be reforged!");
        lore.add("§6LEGENDARY SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        Aspect_of_dragons = item;

        Stats.itemsMap.put(Aspect_of_dragons, new ItemStats(80, 120, 100));
    }

    private static void createAspectOfEnd(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Aspect of the End");
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        List<String> lore = new ArrayList<>();

        lore.add("");
        lore.add("§6Item Ability: Instant Transmission §eRIGHT CLICK");
        lore.add("§7Teleport §a8 blocks §7ahead of");
        lore.add("§7you and gain +2 §fSpeed");
        lore.add("§7for §a3 seconds.");
        lore.add("§8Mana Cost: §350");
        lore.add("");
        lore.add("§8This item can be reforged!");
        lore.add("§9RARE SWORD");

        meta.setLore(lore);
        item.setItemMeta(meta);
        Aspect_of_end = item;

        Stats.itemsMap.put(Aspect_of_end, new ItemStats(40, 8, 50));
    }
}

