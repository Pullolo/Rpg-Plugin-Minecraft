package net.pullolo.commands;

import net.pullolo.Main;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;
import static net.pullolo.stats.Stats.entityMap;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(Main.prefix + "This command can only be used by players!");
            return true;
        }
        Player player = (Player) sender;
        if(cmd.getName().equalsIgnoreCase("heal")){
            if(args.length > 1){
                player.sendMessage( ChatColor.RED + "Usage: /<command> <player>");
            }
            if(args.length == 0) {
                entityMap.get(player).setHealth(entityMap.get(player).getMaxHealth());
                player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                player.setFoodLevel(20);
                player.sendMessage( ChatColor.GREEN + "Healed!");
            }
            if (args.length == 1) {
                Player target = getServer().getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage( ChatColor.RED + "This player is not online!");
                    return true;
                }
                entityMap.get(target).setHealth(entityMap.get(target).getMaxHealth());
                target.setHealth(target.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
                target.setFoodLevel(20);
                player.sendMessage( ChatColor.GREEN + "Healed " + target.getName() + "!");
            }
        }
        return true;
    }
}
