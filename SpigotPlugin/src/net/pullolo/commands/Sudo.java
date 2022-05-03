package net.pullolo.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Sudo implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("sudo")){
            if (args.length >= 2){
                Player target = getServer().getPlayer(args[0]);
                if(target == null){
                    sender.sendMessage(ChatColor.RED + "This player is not online!");
                    return true;
                }
                Bukkit.dispatchCommand(target, returnCommand(args));
                sender.sendMessage(ChatColor.GREEN + "Successful!");
            }
            else {
                sender.sendMessage(ChatColor.RED + "Usage: /<command> <player> <args>");
            }
        }
        return true;
    }

    private String returnCommand(String[] strings){
        String returnedCommand = "";
        for (int i = 1; i<strings.length; i++){
            returnedCommand += strings[i] + " ";
        }
        return returnedCommand;
    }
}
