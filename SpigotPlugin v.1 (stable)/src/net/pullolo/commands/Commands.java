package net.pullolo.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static net.pullolo.Main.prefix;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(prefix + "This command can only be used by players!");
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("hi")) {
            player.chat("Hi guys!");
            if(Bukkit.getServer().getOnlinePlayers().size() < 2){
                player.sendMessage(prefix + "Hi there, i can see you are alone, so Hello My Guy! ;)");
            }
        }

        if (cmd.getName().equalsIgnoreCase("bye")) {
            player.chat("Bye guys!");
            player.kickPlayer("Bye! :)");
        }

        return true;
    }
}
