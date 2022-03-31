package me.anon695.souppvp.commands;

import me.anon695.souppvp.SoupPVP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SoupSpawn implements CommandExecutor {
    private SoupPVP souppvp;
    public SoupSpawn(SoupPVP souppvp) {
        this.souppvp = souppvp;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            //Teleport the player to the spawn
            souppvp.sendSpawn(player);
        }
        return false;
    }
}
