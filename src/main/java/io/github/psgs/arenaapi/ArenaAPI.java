package io.github.psgs.arenaapi;

import org.bukkit.plugin.java.JavaPlugin;

public class ArenaAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!getDataFolder().exists())
            getDataFolder().mkdir();

        if (getConfig() == null)
            saveDefaultConfig();

        ArenaManager.getManager().loadGames();
    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
