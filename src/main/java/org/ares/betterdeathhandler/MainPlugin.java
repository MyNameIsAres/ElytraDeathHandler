package org.ares.betterdeathhandler;

import org.ares.betterdeathhandler.commands.TeleportCommand;
import org.ares.betterdeathhandler.events.DeathTestListener;
import org.ares.betterdeathhandler.events.PlayerQuitListener;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public class MainPlugin extends SimplePlugin {

    @Override
    protected void onPluginStart() {

        registerCommand(new TeleportCommand());
        registerEvents(new DeathTestListener());
        registerEvents(new PlayerQuitListener());


        Common.log("Plugin is enabled!");
    }
}
