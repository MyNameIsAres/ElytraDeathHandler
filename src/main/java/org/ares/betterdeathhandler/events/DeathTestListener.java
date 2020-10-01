package org.ares.betterdeathhandler.events;

import org.ares.betterdeathhandler.utility.DeathLocation;
import org.ares.betterdeathhandler.utility.Settings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.SimpleComponent;

public class DeathTestListener  implements Listener {

    /**
     * This listener listens for a player death event.
     * When a player dies by flying to a wall or
     * falling to their death, while flying with
     * an elytra.
     *
     * The only caveat is this event is also triggered
     * if a player falls while simply wearing an elytra.
     *
     * This may be resolved in another version.
     */

    DeathLocation location = DeathLocation.getInstance();

    @EventHandler
    public void onAnotherDeath(PlayerDeathEvent event) {
        final Player player = event.getEntity();

        if (validDeathCause(player)) {
            if (hasElytra(player)) {

                location.addLocation(player.getLocation());

                Common.log(location.getLocationList().toString());

                SimpleComponent.of(Settings.DEATH_MESSAGE)
                        .onHover("Click to teleport to death location")
                        .onClickRunCmd("/tpadeath")
                        .send(player);
            }
        }
    }

    public boolean validDeathCause(Player player) {
        final EntityDamageEvent.DamageCause damageCause = player.getLastDamageCause().getCause();

        return damageCause.equals(EntityDamageEvent.DamageCause.FLY_INTO_WALL)
                || damageCause.equals(EntityDamageEvent.DamageCause.FALL);
    }

    public boolean hasElytra(Player player) {
        return player.getInventory().getChestplate().getType().equals(Material.ELYTRA);
    }
}
