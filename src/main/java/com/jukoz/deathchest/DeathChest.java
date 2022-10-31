package com.jukoz.deathchest;

import com.jukoz.deathchest.Event.OnPlayerDeath;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class DeathChest extends JavaPlugin {

    @Override
    public void onEnable()  {

        getServer().getConsoleSender().sendMessage(ChatColor.BLUE + "\n\nDeathChest has been enabled \n\n");
        getServer().getPluginManager().registerEvents(new OnPlayerDeath(), this);
        this.getLogger().info("DeathChest Plugin is running");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nDeathChest has been disabled\n\n");
    }
}
