package org.ares.betterdeathhandler.utility;

import lombok.Getter;
import org.bukkit.Location;
import java.util.ArrayList;
import java.util.List;

public class DeathLocation {

    @Getter
    private static final DeathLocation instance = new DeathLocation();

    final List<Location> locationList = new ArrayList<>();

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
