package me.anon695.souppvp;

import me.anon695.souppvp.commands.SoupSetSpawn;
import me.anon695.souppvp.commands.SoupSpawn;
import me.anon695.souppvp.combatmanager.SoupCombatEnter;
import me.anon695.souppvp.combatmanager.SoupCombatLeave;
import me.anon695.souppvp.events.SoupJoinEvent;
import me.anon695.souppvp.events.SoupUseEvent;
import me.anon695.souppvp.kitmanager.KitManager;
import me.anon695.souppvp.kitmanager.basekit;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class SoupPVP extends JavaPlugin {

    public String translate(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public List<UUID> combat = new ArrayList();
    public void sendConsoleMessage(String message) {
        getLogger().info(message);
    }
    public void addCombatTag(Player attacker, Player target) {
        target.sendMessage(translate("&cYou have been tagged by " + attacker.getName() + " DO NOT LOG OUT!"));
        attacker.sendMessage(translate("&cYou have tagged " + target.getName() + " DO NOT LOG OUT!"));
        combat.add(target.getUniqueId());
        combat.add(attacker.getUniqueId());
    }
    public KitManager kitManager;

    @Override
    public void onEnable() {
        try {
            registerConfig();
        } catch (Exception e) {
            sendConsoleMessage(translate("&cError while loading config!"));
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
        try {
            registerEvents();
        } catch (Exception e) {
            sendConsoleMessage(translate("&cError while registering events!"));
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
        try {
            registerCommands();
        } catch (Exception e) {
            sendConsoleMessage(translate("&cError while registering commands!"));
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
        try {
            this.kitManager = kitManager;
        } catch (Exception e) {
            sendConsoleMessage(translate("&cError while registering kit manager!"));
            e.printStackTrace();
        }
        sendConsoleMessage(translate("&aSoupPVP has been enabled!"));
    }

    @Override
    public void onDisable() {
        sendConsoleMessage(translate("&cSoupPVP has been disabled!"));
    }

    public void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new SoupJoinEvent(this), this);
        pm.registerEvents(new SoupUseEvent(), this);
        pm.registerEvents(new SoupCombatEnter(this), this);
        pm.registerEvents(new SoupCombatLeave(this), this);
    }

    public void registerCommands() {
        getCommand("soupspawn").setExecutor(new SoupSetSpawn(this));
        getCommand("spawn").setExecutor(new SoupSpawn(this));
        getCommand("basekit").setExecutor(new basekit(this));
    }

    public void registerConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void sendSpawn(Player player) {
        player.teleport(new Location(Bukkit.getServer().getWorld(getConfig().getString("spawn.world")), getConfig().getDouble("spawn.x"), getConfig().getDouble("spawn.y"), getConfig().getDouble("spawn.z")));
    }
}
