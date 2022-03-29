package com.live.lemonjoey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;



public class tabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String @NotNull [] args) {

        Main plugin = Main.plugin;
        List<String> output = new ArrayList<>();

        switch (args.length) {
            case 0: {
                output.add("reset");
                output.add("reload");
                output.add("confirm");
                return output;
            }
            case 1: {
                if ("confirm".startsWith(args[0]) && sender.hasPermission("randomtp.use")) { output.add("confirm"); }
                if ("reset".startsWith(args[0]) && sender.hasPermission("randomtp.reset")) { output.add("reset"); }
                if ("reload".startsWith(args[0]) && sender.hasPermission("randomtp.reload")) { output.add("reload"); }
                return output;
            }
            case 2: {
                if(args[0].equals("reset") && sender.hasPermission("randomtp.reset")) {

                    for(Player p : plugin.getServer().getOnlinePlayers()) {
                        if (p.getName().startsWith(args[1])) { output.add(p.getName()); }
                    }
                    return output;

                }

            }
        }
        return output;
    }
}

