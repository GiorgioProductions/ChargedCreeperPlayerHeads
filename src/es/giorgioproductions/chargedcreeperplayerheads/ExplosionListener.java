package es.giorgioproductions.chargedcreeperplayerheads;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class ExplosionListener implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDeath(final EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        if (ent instanceof Player) {
            Player p = (Player) ent;
            if (e.getDamager() instanceof Creeper) {
                if(p.getHealth() - e.getFinalDamage() <= 0 && p.getInventory().getItemInMainHand().getType() != Material.TOTEM_OF_UNDYING && p.getInventory().getItemInOffHand().getType() != Material.TOTEM_OF_UNDYING) {
                    Creeper creeper = (Creeper)e.getDamager();
                    if (creeper.isPowered()) {
                        ItemStack playerhead = new ItemStack(Material.PLAYER_HEAD,1);
                        SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                        playerheadmeta.setOwningPlayer((OfflinePlayer) p.getPlayer());
                        playerhead.setItemMeta(playerheadmeta);
                        ent.getWorld().dropItemNaturally(ent.getLocation(),playerhead);
                    }
                }
            }
        }
    }
}
