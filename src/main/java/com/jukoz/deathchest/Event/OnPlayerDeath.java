package com.jukoz.deathchest.Event;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class OnPlayerDeath implements Listener {

    @EventHandler
    void onDeath(PlayerDeathEvent event) {
        final Player player = event.getEntity();
        final Location loc1 = player.getLocation();
        final Location loc2 = new Location(loc1.getWorld(), loc1.getX(), loc1.getY() + 1, loc1.getZ());
        ArrayList<ItemStack> loot1 = new ArrayList<>();
        ArrayList<ItemStack> loot2 = new ArrayList<>();

        for(int x = 0; x < 4; x++) {
            ItemStack item = player.getInventory().getArmorContents()[x];
            if (item.getType() != Material.AIR) {
                loot1.add(item);
                player.getInventory().getArmorContents()[x].setType(Material.AIR);
            }
        }
        player.getInventory().setHelmet(new ItemStack(Material.AIR));
        player.getInventory().setChestplate(new ItemStack(Material.AIR));
        player.getInventory().setLeggings(new ItemStack(Material.AIR));
        player.getInventory().setBoots(new ItemStack(Material.AIR));

        for(int x = 0; x < 36; x++) {
            ItemStack item = player.getInventory().getItem(x);
            if (item != null) {
                if(loot1.size() < 27) {
                    loot1.add(item);
                } else {
                    loot2.add(item);
                }
                player.getInventory().setItem(x, new ItemStack(Material.AIR));
            }
        }

        if(loot1.size() != 0) {
            loc1.getBlock().setType(Material.CHEST);
            Chest chest1 = (Chest) loc1.getBlock().getState();
            chest1.getInventory().setContents(loot1.toArray(new ItemStack[loot1.size()]));
        }

        if(loot2.size() != 0) {
            loc2.getBlock().setType(Material.CHEST);
            Chest chest2 = (Chest) loc2.getBlock().getState();
            chest2.getInventory().setContents(loot2.toArray(new ItemStack[loot2.size()]));
        }
    }
}
