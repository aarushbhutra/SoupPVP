package me.anon695.souppvp.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class SoupUseEvent implements Listener {
    @EventHandler
    public void onSoupUse(PlayerInteractEvent event) {
        //Check if the item is a soup
        if(event.getItem() != null && event.getItem().getType().equals(Material.MUSHROOM_SOUP)) {
            //Add 4 hearts to the player
            event.getPlayer().setHealth(event.getPlayer().getHealth() + 4);
            //Remove the soup
            event.getPlayer().getInventory().remove(Material.MUSHROOM_SOUP);
            //Add a new empty soup
            event.getPlayer().getInventory().addItem(new ItemStack(Material.BOWL));
        }
    }
}
