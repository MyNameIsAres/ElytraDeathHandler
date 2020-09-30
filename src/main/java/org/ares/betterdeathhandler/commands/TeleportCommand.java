package org.ares.betterdeathhandler.commands;

import org.ares.betterdeathhandler.events.DeathTestListener;
import org.ares.betterdeathhandler.utility.DeathLocation;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;
import org.mineacademy.fo.model.SimpleComponent;

public class TeleportCommand extends SimpleCommand {


    public TeleportCommand() {
        super("tpadeath");
    }


    // TODO: general code cleanup
    // TODO: handle no location set

    @Override
    protected void onCommand() {

        boolean hasClicked = false;
        final Player player = getPlayer();

        DeathLocation locationList = DeathLocation.getInstance();
        Location location = locationList.getLocationList().get(0);

        if (location == null) {
            Common.log("It be empty");
        } else {
            
            player.teleport(location);
            Common.log("It worked");
            Common.log(location.toString());
            locationList.removeLocation(location);

            Common.log(location.toString());

        }

    }
}
