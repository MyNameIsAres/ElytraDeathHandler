package org.ares.betterdeathhandler.commands;

import org.ares.betterdeathhandler.MainPlugin;
import org.ares.betterdeathhandler.utility.DeathLocation;
import org.ares.betterdeathhandler.utility.Settings;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * This command is responsible for teleporting the player
 * to their death location.
 *
 * The player is given permission to
 * use the command if they have died while flying an elytra.
 * This permission is revoked immediately after the player is teleported.
 */

public class TeleportCommand extends SimpleCommand {

    private final static String TELEPORT_PERMISSION = "teleport.on.death";
    private final Map<UUID, PermissionAttachment> permissions = new HashMap<>();

    public TeleportCommand() {
        super("tpadeath");
    }

    boolean hasClicked = false;

    @Override
    protected void onCommand() {
        checkConsole();

        PermissionAttachment permission = getPlayer().addAttachment(MainPlugin.getInstance(), TELEPORT_PERMISSION, true);

        final Player player = getPlayer();
        final DeathLocation locationList = DeathLocation.getInstance();

        if (!(locationList.getLocationList().isEmpty())) {
            permissions.put(getPlayer().getUniqueId(), permission);

            final Location location = locationList.getLocationList().get(0);
            player.teleport(location);


            Common.tell(player, Settings.TELEPORT_SUCCESS_MESSAGE);
            locationList.removeLocation(location);

            permissions.remove(getPlayer().getUniqueId());
            hasClicked = true;
        } else {
            Common.tell(player, Settings.TELEPORT_DENY_MESSAGE);
            hasClicked = false;
        }

    }
}
