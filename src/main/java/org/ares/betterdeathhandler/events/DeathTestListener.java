package org.ares.betterdeathhandler.events;

import org.ares.betterdeathhandler.utility.DeathLocation;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleComponent;

public class DeathTestListener  implements Listener {

    DeathLocation location = DeathLocation.getInstance();

    @EventHandler
    public void onAnotherDeath(PlayerDeathEvent event) {
        final Player player = event.getEntity();

        // TODO: Externalize validation of Elytra usage CHECK
        // TODO: Better messages (config?)
        // TODO: Code clean up. CHECK


        if (validDeathCause(player)) {
            if (hasElytra(player)) {
                Common.log("Testing");

                location.addLocation(player.getLocation());

                SimpleComponent.of("&cOuch! Hit the ground too hard? Click me to return to your death location")
                        .onHover("Click to teleport to death location")
                        .onClickRunCmd("/tpadeath")
                        .send(player);

            } else {
                Common.log("Why it no worky");
            }
        } else {
            Common.log(String.valueOf(player.getLastDamageCause().getCause()));
        }

    }

    public boolean validDeathCause(Player player) {
        EntityDamageEvent.DamageCause damageCause = player.getLastDamageCause().getCause();

        return damageCause.equals(EntityDamageEvent.DamageCause.FLY_INTO_WALL)
                || damageCause.equals(EntityDamageEvent.DamageCause.FALL);
    }

    public boolean hasElytra(Player player) {
        return player.getInventory().getChestplate().getType().equals(Material.ELYTRA);
    }

}
