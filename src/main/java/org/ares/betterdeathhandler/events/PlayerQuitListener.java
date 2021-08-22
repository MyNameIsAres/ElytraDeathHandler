package org.ares.betterdeathhandler.events;

import org.ares.betterdeathhandler.storage.DeathLocation;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class PlayerQuitListener implements Listener {

    public DeathLocation deathLocation;

    public PlayerQuitListener(DeathLocation deathLocation) {
        this.deathLocation = deathLocation;
    }

    /**
     * This listener exists as a safety check.
     * Without this class the player can teleport to their previous
     * location after logging off and on.
     *
     * This extra safety check and be removed by deleting the class.
     */

    @EventHandler
    public void onAnotherDeath(PlayerQuitEvent event) {
        if (!(deathLocation.getLocationList().isEmpty())) {
            Location location = deathLocation.getLocationList().get(0);
            deathLocation.removeLocation(location);
        }
    }
}
