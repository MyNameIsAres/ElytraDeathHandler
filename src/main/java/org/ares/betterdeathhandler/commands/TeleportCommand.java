package org.ares.betterdeathhandler.commands;

import org.ares.betterdeathhandler.MainPlugin;
import org.ares.betterdeathhandler.utility.DeathLocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class TeleportCommand extends SimpleCommand {
    private final static String TELEPORT_PERMISSION = "teleport.on.death";
    private final Map<UUID, PermissionAttachment> permissions = new HashMap<>();

    public TeleportCommand() {
        super("tpadeath");
    }


    // TODO: general code cleanup

    boolean hasClicked = false;

    @Override
    protected void onCommand() {
        PermissionAttachment permission = getPlayer().addAttachment(MainPlugin.getInstance(), TELEPORT_PERMISSION, true);

        final Player player = getPlayer();
        DeathLocation locationList = DeathLocation.getInstance();

        if (locationList.getLocationList().isEmpty()) {
            Common.tell(player, "&cSorry! You can only return to this location once!");
            hasClicked = false;
        } else {
            permissions.put(getPlayer().getUniqueId(), permission);

                Location location = locationList.getLocationList().get(0);
                player.teleport(location);
                Common.tell(player, "&2Teleported you back!");
                locationList.removeLocation(location);

//                permissions.remove(getPlayer().getUniqueId());
            permissions.remove(getPlayer().getUniqueId());

            hasClicked = true;
        }

    }
}
