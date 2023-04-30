package com.justinschaaf.infinitifall;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandHandler implements CommandExecutor {

    private Infinitifall plugin;

    public CommandHandler(Infinitifall plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean unknown = true;

        if (args.length > 0) {

            switch (args[0]) {

                case "reload" -> {

                    if (!sender.hasPermission("infinitifall.reload")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.msgErrorNoPerms));
                        break;
                    }

                    try {
                        Config.load(plugin);
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.msgReloadConfirmed));
                    } catch (Exception e) {
                        e.printStackTrace();
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.msgReloadErrored));
                    }

                    unknown = false;

                }

            }

        } else unknown = true;

        // Use this so we get to format the message rather than returning false and having Bukkit/Spigot/Paper do it for us
        if (unknown)
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Config.msgErrorUnknownCmd));

        return true;

    }

}