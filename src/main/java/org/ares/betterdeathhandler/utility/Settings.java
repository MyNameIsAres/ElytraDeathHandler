package org.ares.betterdeathhandler.utility;

import org.mineacademy.fo.settings.SimpleSettings;

public class Settings extends SimpleSettings {

    /**
     * This class is responsible for fetching configuration
     * messages from the 'config.yml' file. There are 3 messages
     * to be fetched from the config.
     *
     * The config version represents the version of the config file.
     * Changes to the config file from the developer increase the
     * version of the config by one (manually)
     */



    @Override
    protected int getConfigVersion() {
        return 1;
    }

    @Override
    protected String[] getHeader() {
        return new String[] {
                "Config file BetterDeathHandler"
        };
    }

    @Override
    protected String getSettingsFileName() {
        return "config.yml";
    }

    public static String DEATH_MESSAGE;
    public static String TELEPORT_DENY_MESSAGE;
    public static String TELEPORT_SUCCESS_MESSAGE;

    private static void init() {
        pathPrefix("Messages");
        DEATH_MESSAGE = getString("Death_Message");
        TELEPORT_DENY_MESSAGE = getString("Teleport_Deny_Message");
        TELEPORT_SUCCESS_MESSAGE = getString("Teleport_Success_Message");
    }
}
