package com.github.kamida.cursedmagicmirror.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class itemManager {
    public static ItemStack mirror;

    public static void init() {
        createMirror();
    }

    public static void createMirror() {
        ItemStack item = new ItemStack(Material.NAUTILUS_SHELL);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§l§cCursed Magic Mirror"); // Unsure if this makes the name red

        /* Set Item Lore */
        List<String> lore = new ArrayList<>();
        lore.add("Randomly damages user 0-20 health upon use");
        lore.add("Yes, it can kill you");
        meta.setLore(lore);

        /* Visual Aspects */
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);

        mirror = item;

        // TODO Crafting Recipe
    }
}
