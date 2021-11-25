package me.combathax.mendingtoggle;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerItemMendEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Events implements Listener {
    private JavaPlugin plugin;
    public Events(JavaPlugin p){
        plugin = p;
    }
    @EventHandler
    public void onMendEvent(PlayerItemMendEvent e){
        if (!((boolean) plugin.getConfig().get(e.getPlayer().getUniqueId() + ".mending"))){
            e.setCancelled(true);
            e.getPlayer().giveExp(e.getExperienceOrb().getExperience());
        }
    }
}
