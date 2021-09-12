package org.ares.betterdeathhandler;

import lombok.Getter;
import org.ares.betterdeathhandler.commands.TeleportCommand;
import org.ares.betterdeathhandler.events.PlayerDeathListener;
import org.ares.betterdeathhandler.events.PlayerQuitListener;
import org.ares.betterdeathhandler.permissions.PermissionManager;
import org.ares.betterdeathhandler.storage.DeathLocation;
import org.ares.betterdeathhandler.utility.Settings;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.Collections;
import java.util.List;

public class MainPlugin extends SimplePlugin {


    @Getter
    DeathLocation deathLocation = new DeathLocation();

    PermissionManager permissionManager = new PermissionManager();

    @Override
    protected void onPluginStart() {
        Common.log("BetterElytraDeath has been enabled!");

        registerCommand(new TeleportCommand(permissionManager, deathLocation));
        registerEvents(new PlayerDeathListener(deathLocation, permissionManager));
        registerEvents(new PlayerQuitListener(deathLocation));

    }

    @Override
    public List<Class<? extends YamlStaticConfig>> getSettings() {
        return Collections.singletonList(Settings.class);
    }
}
