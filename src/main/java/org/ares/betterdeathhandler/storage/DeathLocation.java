package org.ares.betterdeathhandler.storage;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;

public class DeathLocation {

    // TODO: In the future probably wanna save this in a cache file temporarily in case they relog.

    @Setter
    @Getter
    Location location;

}
