package me.anon695.souppvp.commands;

import me.anon695.souppvp.SoupPVP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SoupSetSpawn implements CommandExecutor {

    private SoupPVP souppvp;
    public SoupSetSpawn(SoupPVP souppvp) {
        this.souppvp = souppvp;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("souppvp.setspawn")) {
                //Save the player's location in the config
                //Set the players world to the world the player is in
                souppvp.getConfig().set("spawn.world", player.getWorld().getName());
                souppvp.getConfig().set("spawn.x", player.getLocation().getX());
                souppvp.getConfig().set("spawn.y", player.getLocation().getY());
                souppvp.getConfig().set("spawn.z", player.getLocation().getZ());
                souppvp.getConfig().set("spawn.yaw", player.getLocation().getYaw());
                souppvp.getConfig().set("spawn.pitch", player.getLocation().getPitch());
                souppvp.saveConfig();
                player.sendMessage(souppvp.translate("&aSpawn location set to your location! &7(X: &6" + player.getLocation().getX() + "&7, Y: &6" + player.getLocation().getY() + "&7, Z: &6" + player.getLocation().getZ() + "&7)"));
            } else {
                player.sendMessage(souppvp.translate("&cYou do not have permission to use this command!"));
            }
        } else {
            sender.sendMessage("You must be a player to use this command!");
        }
        return false;
    }
}
