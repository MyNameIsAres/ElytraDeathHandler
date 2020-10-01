package org.ares.betterdeathhandler;

import org.ares.betterdeathhandler.commands.TeleportCommand;
import org.ares.betterdeathhandler.events.DeathTestListener;
import org.ares.betterdeathhandler.events.PlayerQuitListener;
import org.ares.betterdeathhandler.utility.Settings;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import org.mineacademy.fo.settings.YamlStaticConfig;

import java.util.Collections;
import java.util.List;

public class MainPlugin extends SimplePlugin {

    @Override
    protected void onPluginStart() {

        Common.log("BetterElytraDeath has been enabled!");

        registerCommand(new TeleportCommand());
        registerEvents(new DeathTestListener());
        registerEvents(new PlayerQuitListener());

    }

    @Override
    public List<Class<? extends YamlStaticConfig>> getSettings() {
        return Collections.singletonList(Settings.class);
    }
}
