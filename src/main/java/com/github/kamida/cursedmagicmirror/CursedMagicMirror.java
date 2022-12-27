package com.github.kamida.cursedmagicmirror;

import com.github.kamida.cursedmagicmirror.commands.commands;
import com.github.kamida.cursedmagicmirror.events.teleportEvent;
import com.github.kamida.cursedmagicmirror.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CursedMagicMirror extends JavaPlugin {

    public static CursedMagicMirror instance;

    public static CursedMagicMirror getInstance() {
        return instance;
    }

    public static void logConsole(String message) {
        Bukkit.getConsoleSender().sendMessage("[Cursed Magic Mirror]"  + message);
    }

    @Override
    public void onEnable() {
        itemManager.init();
        getCommand("cursedmm").setExecutor(new commands());
        getServer().getPluginManager().registerEvents(new teleportEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
