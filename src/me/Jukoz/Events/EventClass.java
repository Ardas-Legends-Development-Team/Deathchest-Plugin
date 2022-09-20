package me.Jukoz.Events;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
	

public class EventClass implements Listener { 
    
    
    @EventHandler 
    void onDeath(PlayerDeathEvent event) {
        final Player player = event.getEntity();
        final Location loc = player.getLocation();
        ArrayList<ItemStack> content = new ArrayList<ItemStack>();
               
        loc.getBlock().setType(Material.CHEST);
        
        Chest chest = (Chest) loc.getBlock().getState();      
        
        for(int x = 9; x < 36; x++) {
        	ItemStack item = player.getInventory().getItem(x);
        	if (item != null) {
        		content.add(item);
        		player.getInventory().setItem(x, new ItemStack(Material.AIR));
        	}
        	chest.getInventory().setContents(content.toArray(new ItemStack[content.size()]));
        }
    }
}
