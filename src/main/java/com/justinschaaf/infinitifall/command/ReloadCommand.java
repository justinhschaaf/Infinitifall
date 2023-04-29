package com.justinschaaf.infinitifall.command;

import com.justinschaaf.infinitifall.util.MiscUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("infinitifall.reload")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command.");
            return true;
        try {
            MiscUtil.reload();
            sender.sendMessage(ChatColor.GREEN + "InfinitiFall reloaded.");
        } catch (Exception e) {
            sender.sendMessage(ChatColor.RED + "Something went wrong reloading InfinitiFall, see the console for more.");
            e.printStackTrace();
        }
        return true;
    }
}