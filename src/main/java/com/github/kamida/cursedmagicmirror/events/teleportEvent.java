package com.github.kamida.cursedmagicmirror.events;

import com.github.kamida.cursedmagicmirror.items.itemManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import java.lang.Math;

public class teleportEvent implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if ((event.getAction() == Action.RIGHT_CLICK_AIR )|| (event.getAction() ==  Action.RIGHT_CLICK_BLOCK)) {
            if (event.getItem() != null) {
                if (event.getItem().getItemMeta().equals(itemManager.mirror.getItemMeta())) {
                    Player player = event.getPlayer();

                    double hp = (int) ((Math.random() * (0 - 20 + 1)) * -1);

                    if (hp == 0.0) {
                        player.sendMessage("Lucky, Mirror took no health away");
                    } else {
                        player.sendMessage("The mirror took " + hp + " of health away.");
                    }
                    player.damage(hp);

                    if (player.getBedSpawnLocation() != null) {
                        player.teleport(player.getBedSpawnLocation());
                    } else {
                        player.teleport(player.getWorld().getSpawnLocation());
                    }
                }
            }
        }
    }
}
