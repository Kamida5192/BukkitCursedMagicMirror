package com.github.kamida.cursedmagicmirror.commands;

import com.github.kamida.cursedmagicmirror.items.itemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class commands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }

        if(!player.hasPermission("cursedmm.give")) {
            sender.sendMessage("You do not have the permission cursedmm.give");
            return true;
        }

        if (command.getName().equalsIgnoreCase("cmm")) {
            sender.sendMessage("Given Cursed Magic Mirror");
            player.getInventory().addItem(itemManager.mirror);
            return true;
        }
        return true;
    }
}
