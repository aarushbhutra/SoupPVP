package me.anon695.souppvp.combatmanager;

import me.anon695.souppvp.SoupPVP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class SoupCombatEnter implements Listener {
    private SoupPVP soupPVP;
    public SoupCombatEnter(SoupPVP soupPVP) {
        this.soupPVP = soupPVP;
    }

    @EventHandler
    public void combatEnter(EntityDamageByEntityEvent e) {
        //Check if the entity is a player
        if(e.getEntity() instanceof Player) {
            Player target = (Player) e.getEntity();
            //Check if the damager is a player
            if(e.getDamager() instanceof Player) {
                Player damager = (Player) e.getDamager();
                soupPVP.addCombatTag(damager, target);
            }
        }
    }
}
