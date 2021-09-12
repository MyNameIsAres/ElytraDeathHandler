package org.ares.betterdeathhandler.commands;

import org.ares.betterdeathhandler.permissions.PermissionManager;
import org.ares.betterdeathhandler.storage.DeathLocation;
import org.ares.betterdeathhandler.utility.Settings;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.PlayerUtil;
import org.mineacademy.fo.command.SimpleCommand;

/**
 * This command is responsible for teleporting the player
 * to their death location.
 *
 * The player is given permission to
 * use the command if they have died while flying an elytra.
 * This permission is revoked immediately after the player is teleported.
 */

public class TeleportCommand extends SimpleCommand {

    private final PermissionManager permissionManager;
    private final DeathLocation deathLocation;

    public TeleportCommand(PermissionManager permissionManager, DeathLocation deathLocation) {
        super("tpadeath");

        this.permissionManager = permissionManager;
        this.deathLocation = deathLocation;
    }


    @Override
    protected void onCommand() {
        checkConsole();

        final Location location = deathLocation.getLocation();
        final Player player = getPlayer();

        if (PlayerUtil.hasPerm(player, PermissionManager.TELEPORT_PERMISSION)) {
            player.teleport(location);
            Common.tell(player, Settings.TELEPORT_SUCCESS_MESSAGE);

            permissionManager.removePermission(getPlayer());
        } else {
            Common.tell(player, Settings.TELEPORT_DENY_MESSAGE);
        }
    }
}
