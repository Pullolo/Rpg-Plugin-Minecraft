package net.pullolo.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import net.pullolo.items.Items;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class GiveCustomItems implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("giveitem")){
            if (args.length >= 2){
                Player target = getServer().getPlayer(args[0]);
                if(target == null){
                    sender.sendMessage(ChatColor.RED + "This player is not online!");
                    return true;
                }
                if (args[1].equalsIgnoreCase("list")){
                    target.sendMessage("------------Items List-----------");
                    TextComponent m1 = new TextComponent("aspectofend");
                    m1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to get the item!")));
                    m1.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ("/giveitem " + target.getPlayerListName() + " aspectofend")));
                    target.spigot().sendMessage(m1);
                    TextComponent m2 = new TextComponent("aspectofdragons");
                    m2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to get the item!")));
                    m2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/giveitem " + target.getPlayerListName() + " aspectofdragons"));
                    target.spigot().sendMessage(m2);
                    TextComponent m3 = new TextComponent("leapingsword");
                    m3.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to get the item!")));
                    m3.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/giveitem " + target.getPlayerListName() + " leapingsword"));
                    target.spigot().sendMessage(m3);
                    TextComponent m4 = new TextComponent("hyperion");
                    m4.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to get the item!")));
                    m4.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/giveitem " + target.getPlayerListName() + " hyperion"));
                    target.spigot().sendMessage(m4);
                    TextComponent m5 = new TextComponent("healingwand");
                    m5.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to get the item!")));
                    m5.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/giveitem " + target.getPlayerListName() + " healingwand"));
                    target.spigot().sendMessage(m5);
                    TextComponent m6 = new TextComponent("speedarmour");
                    m6.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to get the ArmorSet!")));
                    m6.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/giveitem " + target.getPlayerListName() + " speedarmour"));
                    target.spigot().sendMessage(m6);
                    target.sendMessage("-------------------------------");
                }
                if (args[1].equalsIgnoreCase("aspectofend")){
                    target.getInventory().addItem(Items.Aspect_of_end);
                }
                if (args[1].equalsIgnoreCase("aspectofdragons")){
                    target.getInventory().addItem(Items.Aspect_of_dragons);
                }
                if (args[1].equalsIgnoreCase("leapingsword")){
                    target.getInventory().addItem(Items.Leaping_sword);
                }
                if (args[1].equalsIgnoreCase("hyperion")){
                    target.getInventory().addItem(Items.Hyperion);
                }
                if (args[1].equalsIgnoreCase("healingwand")){
                    target.getInventory().addItem(Items.Healing_wand);
                }
                if (args[1].equalsIgnoreCase("speedarmour")){
                    target.getInventory().addItem(Items.Speed_Helmet);
                    target.getInventory().addItem(Items.Speed_Chestplate);
                    target.getInventory().addItem(Items.Speed_Leggings);
                    target.getInventory().addItem(Items.Speed_Boots);
                }
            }
            else {
                sender.sendMessage(ChatColor.RED + "Usage: /<command> <player> <args>");
            }
        }
        return true;
    }
}
