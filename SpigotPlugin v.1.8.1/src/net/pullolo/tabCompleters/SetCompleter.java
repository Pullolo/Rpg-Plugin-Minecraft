package net.pullolo.tabCompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class SetCompleter implements TabCompleter {

    //todo add a list of completed values to set cmd here (not in Main cause I did it)
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        return null;
    }
}
