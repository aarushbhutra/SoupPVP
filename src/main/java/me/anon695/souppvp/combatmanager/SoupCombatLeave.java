package me.anon695.souppvp.combatmanager;

import me.anon695.souppvp.SoupPVP;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SoupCombatLeave implements Listener {
    private SoupPVP soupPVP;
    public SoupCombatLeave(SoupPVP soupPVP) {
        this.soupPVP = soupPVP;
    }
    private final List<UUID> toKill = new ArrayList<>();

    @EventHandler
    public void combatLeave(PlayerQuitEvent e) {
        if(soupPVP.combat.contains(e.getPlayer().getUniqueId())) {
            soupPVP.combat.remove(e.getPlayer().getUniqueId());
            toKill.add(e.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(toKill.contains(e.getPlayer().getUniqueId())) {
            toKill.remove(e.getPlayer().getUniqueId());
            e.getPlayer().setHealth(0);
            e.getPlayer().spigot().respawn();
            e.getPlayer().sendMessage(soupPVP.translate("&cYou were killed due to combat logging."));
        }
    }
}
