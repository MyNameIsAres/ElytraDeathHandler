package org.ares.betterdeathhandler.utility;

import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeathLocation {

    @Getter
    private static final DeathLocation instance = new DeathLocation();

    final List<Location> locationList = new ArrayList<>();

    private DeathLocation() {

    }

    public void addLocation(Location location) {
        locationList.add(location);
    }

    public List<Location> getLocationList() {
        return locationList;
    }

    public void removeLocation(Location location) {
        locationList.remove(location);
    }


}
