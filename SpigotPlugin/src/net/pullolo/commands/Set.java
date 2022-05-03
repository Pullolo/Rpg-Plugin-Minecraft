package net.pullolo.commands;

import net.pullolo.Entities.EntityConverter;
import net.pullolo.stats.Stats;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;
import static net.pullolo.stats.Stats.manaMap;

public class Set implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mana")){
            if (!(sender instanceof Player)){
                return true;
            }
            Player player = (Player) sender;
            player.sendMessage(ChatColor.BLUE + "You have " + ChatColor.AQUA + manaMap.get(player).getMana() + "/" + manaMap.get(player).getMaxMana() + ChatColor.BLUE + " mana.");
            manaMap.get(player).getMana();
        }
        if (cmd.getName().equalsIgnoreCase("set")){
            if (args.length >= 2){
                Player target = getServer().getPlayer(args[0]);
                if(target == null){
                    sender.sendMessage(ChatColor.RED + "This player is not online!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("list")){
                    target.sendMessage("mana");
                    target.sendMessage("maxmana");
                    target.sendMessage("manaregen");
                }
                if (args.length >= 3){
                    if (args[1].equalsIgnoreCase("level")){
                        try {
                            if (Integer.parseInt(args[2]) > 0){
                                Stats.entityMap.get(target).setLevel(Integer.parseInt(args[2]));
                                Stats.entityMap.get(target).setHealth(Integer.parseInt(args[2])*20);
                            }
                            else {
                                target.sendMessage(ChatColor.RED + "Wrong Value!");
                            }
                        }catch (Exception e){
                            target.sendMessage(ChatColor.RED + "Wrong Value!");
                            return true;
                        }
                    }


                    if (args[1].equalsIgnoreCase("mana")){
                        try {
                            manaMap.get(target).setMana(Integer.parseInt(args[2]));
                        }catch (Exception e){
                            target.sendMessage(ChatColor.RED + "Wrong Value!");
                            return true;
                        }
                    }
                    if (args[1].equalsIgnoreCase("maxmana")){
                        try {
                            manaMap.get(target).setMaxMana(Integer.parseInt(args[2]));
                        }catch (Exception e){
                            target.sendMessage(ChatColor.RED + "Wrong Value!");
                            return true;
                        }
                    }
                    if (args[1].equalsIgnoreCase("manaregen")){
                        try {
                            manaMap.get(target).setManaRegen(Integer.parseInt(args[2]));
                        }catch (Exception e){
                            target.sendMessage(ChatColor.RED + "Wrong Value!");
                            return true;
                        }
                    }
                }
                sender.sendMessage(ChatColor.GREEN + "Successful!");
            }
            else {
                sender.sendMessage(ChatColor.RED + "Usage: /<command> <player> <attribute> <value>");
            }
        }
        return true;
    }
}
