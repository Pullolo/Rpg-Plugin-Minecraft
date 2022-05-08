package net.pullolo.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Max implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("max")){
            if(args.length == 1){
                if (!(sender instanceof Player)){
                    return true;
                }
                Player player = (Player) sender;
                if (args[0].equalsIgnoreCase("list")){
                    player.sendMessage("sword");
                    player.sendMessage("armour");
                }
                if(player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getType().toString().toLowerCase().contains("sword")){
                    if(args[0].equalsIgnoreCase("sword")){
                        player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DAMAGE_ALL, 5);
                        player.getInventory().getItemInMainHand().addEnchantment(Enchantment.FIRE_ASPECT, 2);
                        player.getInventory().getItemInMainHand().addEnchantment(Enchantment.LOOT_BONUS_MOBS, 3);
                        player.getInventory().getItemInMainHand().addEnchantment(Enchantment.SWEEPING_EDGE, 3);
                        player.getInventory().getItemInMainHand().addEnchantment(Enchantment.MENDING, 1);
                        player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, 3);
                    }
                }
                if(player.getInventory().getItemInMainHand().getItemMeta() != null){
                    if(args[0].equalsIgnoreCase("armour")){
                        if(player.getInventory().getItemInMainHand().getType().toString().toLowerCase().contains("helmet")){
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.OXYGEN, 3);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.WATER_WORKER, 1);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.MENDING, 1);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, 3);
                        }
                        if(player.getInventory().getItemInMainHand().getType().toString().toLowerCase().contains("chestplate")){
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.MENDING, 1);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, 3);
                        }
                        if(player.getInventory().getItemInMainHand().getType().toString().toLowerCase().contains("leggings")){
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.MENDING, 1);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, 3);
                        }
                        if(player.getInventory().getItemInMainHand().getType().toString().toLowerCase().contains("boots")){
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.PROTECTION_FALL, 4);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DEPTH_STRIDER, 3);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.SOUL_SPEED, 3);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.MENDING, 1);
                            player.getInventory().getItemInMainHand().addEnchantment(Enchantment.DURABILITY, 3);
                        }
                    }
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "Usage: /<command> <itemType>");
            }
        }
        return true;
    }
}
