package org.ares.betterdeathhandler.events;

import org.ares.betterdeathhandler.permissions.PermissionManager;
import org.ares.betterdeathhandler.storage.DeathLocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.mineacademy.fo.PlayerUtil;


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
    public void onPlayerQuit(PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        if (PlayerUtil.hasPerm(player, PermissionManager.TELEPORT_PERMISSION)) {
            // TODO: Write to cache file and add uuid + location to list for T time period.
        }

    }
}
