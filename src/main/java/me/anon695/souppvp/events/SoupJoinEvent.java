package me.anon695.souppvp.events;

import me.anon695.souppvp.SoupPVP;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SoupJoinEvent implements Listener {
    private SoupPVP soupPVP;
    public SoupJoinEvent(SoupPVP soupPVP) {
        this.soupPVP = soupPVP;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        //Check if any variables are null
        if (soupPVP.getConfig().getString("spawn.world") == null || soupPVP.getConfig().getString("spawn.x") == null || soupPVP.getConfig().getString("spawn.y") == null || soupPVP.getConfig().getString("spawn.z") == null) {
            if(!e.getPlayer().isOp()) {
                e.getPlayer().kickPlayer("§c[SoulPVP] §cThe spawn is not set properly! Please contact an admin.");
            } else {
                e.getPlayer().sendMessage("§c[SoulPVP] §cThe spawn is not set properly! Please run the command /soupspawn");
            }
        }
        soupPVP.sendSpawn(e.getPlayer());
    }
}
