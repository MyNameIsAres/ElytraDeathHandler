package org.ares.betterdeathhandler.permissions;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PermissionManager {

    public final static String TELEPORT_PERMISSION = "teleport.on.death";


    private final Map<UUID, PermissionAttachment> permissions = new HashMap<>();

    public void addPermission(final Player player, final PermissionAttachment permission) {
        permissions.put(player.getUniqueId(), permission);
    }

    public void removePermission(final Player player) {
        permissions.remove(player.getUniqueId());
    }

}
