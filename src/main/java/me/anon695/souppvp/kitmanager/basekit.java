package me.anon695.souppvp.kitmanager;

import me.anon695.souppvp.SoupPVP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class basekit implements CommandExecutor, Listener {
    private SoupPVP soupPVP;
    public basekit(SoupPVP soupPVP) {
        this.soupPVP = soupPVP;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("souppvp.basekit")) {
                soupPVP.kitManager.giveKit(player, KitManager.Kits.BASEKIT, "&cGiven the basekit");
            }
        }
        return false;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        soupPVP.kitManager.giveKit(e.getPlayer(), KitManager.Kits.BASEKIT, "&cGiven the basekit");
    }
}
