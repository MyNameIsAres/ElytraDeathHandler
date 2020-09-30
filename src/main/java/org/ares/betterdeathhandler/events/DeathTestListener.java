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

        // TODO: Externalize validation of Elytra usage
        // TODO: Better messages (config?)
        // TODO: Code clean up.

        if (player.getLastDamageCause().getCause().equals(EntityDamageEvent.DamageCause.FLY_INTO_WALL)) {
           if (player.getInventory().getChestplate().getType().equals(Material.ELYTRA)) {

               location.addLocation(player.getLocation());

               Common.log(location.getLocationList().toString()  + "I am the array.");

               SimpleComponent.of("&7Ouch! Hit the ground too hard? You died at\n"
                       + player.getLocation().getX()
                       + " " + player.getLocation().getY()
                       + " " + player.getLocation().getZ())
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

}
