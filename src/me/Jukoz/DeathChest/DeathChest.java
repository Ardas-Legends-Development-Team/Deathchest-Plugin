package me.Jukoz.DeathChest;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.Jukoz.Events.EventClass;

public class DeathChest extends JavaPlugin{
	
	//EventClass eventClass = new EventClass();

	@Override
	public void onEnable()  {
		
		getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "\n\nDeathChest has been enabled \n\n");
		getServer().getPluginManager().registerEvents(new EventClass(), this);
		this.getLogger().info("DeathChest Plugin is running");
	}
	
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nDeathChest has been disabled\n\n");
	}	
}

