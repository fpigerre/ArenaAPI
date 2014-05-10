package io.github.psgs.arenaapi;

import org.bukkit.plugin.java.JavaPlugin;

public class ArenaAPI extends JavaPlugin {

    private static ArenaAPI instance;

    @Override
    public void onEnable() {
        instance = this;
        if (!getDataFolder().exists())
            getDataFolder().mkdir();

        if (getConfig() == null)
            saveDefaultConfig();

        ArenaManager.getManager().loadArenas();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }

    public static ArenaAPI getInstance() {
        return instance;
    }
}