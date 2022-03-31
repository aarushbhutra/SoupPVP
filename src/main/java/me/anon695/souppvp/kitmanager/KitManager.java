package me.anon695.souppvp.kitmanager;

import me.anon695.souppvp.SoupPVP;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class KitManager {
    enum Kits {
        BASEKIT
    }
    private SoupPVP soupPVP;
    public KitManager(SoupPVP soupPVP) {
        this.soupPVP = soupPVP;
    }
    private List<UUID> using = new ArrayList<>();
    public void giveKit(Player player, Kits kits, String message) {
        using.add(player.getUniqueId());
        if (using.contains(player.getUniqueId())) {
            player.sendMessage(soupPVP.translate("&cYou are already using a kit!"));
        } else {
            if(kits == Kits.BASEKIT) {
                player.sendMessage(soupPVP.translate(message));
                player.getInventory().clear();
                for (int i = 0; i < player.getInventory().getSize(); i++) {
                    player.getInventory().setItem(i, new ItemStack(Material.MUSHROOM_SOUP));
                }
                player.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
                player.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
                player.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
                player.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
                player.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
                player.getInventory().setItem(1, new ItemStack(Material.BOW));
                player.getInventory().setItem(2, new ItemStack(Material.ARROW, 64));
                player.getInventory().setItem(3, new ItemStack(Material.COOKED_BEEF, 64));
            }
        }
    }
}

