package com.justinschaaf.infinitifall.command;

import com.justinschaaf.infinitifall.Infinitifall;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("infinitifall.reload")) return true;
        try {
            Infinitifall.MiscUtil.reload();
            sender.sendMessage(ChatColor.YELLOW + "InfinitiFall reloaded.");
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "Something went wrong reloading InfinitiFall, see the console for more.");
            e.printStackTrace();
        }
        return true;
    }
}