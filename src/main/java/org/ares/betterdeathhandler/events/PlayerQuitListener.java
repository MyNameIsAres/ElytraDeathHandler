package org.ares.betterdeathhandler.events;

import org.ares.betterdeathhandler.utility.DeathLocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.Common;

public class PlayerQuitListener implements Listener {

    /**
     * This listener exists as a safety check.
     * Without this class the player can teleport to their previous
     * location after logging off and on.
     *
     * This extra safety check and be removed by deleting the class.
     */

    @EventHandler
    public void onAnotherDeath(PlayerQuitEvent event) {
        DeathLocation locations = DeathLocation.getInstance();

        if (!(locations.getLocationList().isEmpty())) {
            Location location = locations.getLocationList().get(0);
            locations.removeLocation(location);
        }
    }



}
