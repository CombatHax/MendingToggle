package me.combathax.mendingtoggle;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Commands implements CommandExecutor {
    private JavaPlugin plugin;
    public Commands(JavaPlugin p){
        plugin = p;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mendingtoggle")){
            if (sender instanceof Player){
                Player p = (Player) sender;
                if (plugin.getConfig().contains(p.getUniqueId() + ".mending")){
                    plugin.getConfig().set(p.getUniqueId() + ".mending",  !((boolean) plugin.getConfig().get(p.getUniqueId() + ".mending")));
                }
                else {
                    plugin.getConfig().set(p.getUniqueId() + ".mending", true);
                }
                plugin.saveConfig();
                p.sendMessage(ChatColor.AQUA + "Mending is now: " + plugin.getConfig().get(p.getUniqueId() + ".mending").toString());
                if (!((boolean) plugin.getConfig().get(p.getUniqueId() + ".mending"))){
                    for (int i = 0; i < p.getInventory().getSize(); i++){
                        if (p.getInventory().getItem(i) != null){
                            ItemStack item = p.getInventory().getItem(i);
                            if (item.getEnchantments().containsKey(Enchantment.MENDING)){
                                ItemMeta m = item.getItemMeta();
                                if (m.getLore() != null) {
                                    List<String> l = m.getLore();
                                    l.add("MENDING OFF");
                                    item.setItemMeta(m);
                                }
                            }
                        }
                    }
                }

            }

        }
        return true;
    }
}
