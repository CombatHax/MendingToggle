package me.combathax.mendingtoggle;

import org.bukkit.plugin.java.JavaPlugin;

public final class Mendingtoggle extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("mendingtoggle").setExecutor(new Commands(this));
        this.getServer().getPluginManager().registerEvents(new Events(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
