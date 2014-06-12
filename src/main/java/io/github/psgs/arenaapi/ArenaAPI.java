package io.github.psgs.arenaapi;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ArenaAPI extends JavaPlugin implements CommandExecutor {

    private static ArenaAPI instance;
    private Location spawn;
    private Location l1;
    private Location l2;

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

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("arena")) {
            if (args.length > 0) {
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    if (args[0].equalsIgnoreCase("add")) {
                        spawn = player.getLocation();
                        if (l1 != null && l2 != null) {
                            ArenaManager.getManager().createArena(spawn, l1, l2);
                        }
                    }
                    if (args[0].equalsIgnoreCase("pos1")) {
                        l1 = player.getLocation();
                    }
                    if (args[0].equalsIgnoreCase("pos2")) {
                        l2 = player.getLocation();
                    }
                    if (args[0].equalsIgnoreCase("join")) {
                        ArenaManager.getManager().addPlayer(player, 1);
                    }
                    if (args[0].equalsIgnoreCase("leave")) {
                        ArenaManager.getManager().removePlayer(player);
                    }
                    if (args[0].equalsIgnoreCase("reload")) {
                        ArenaManager.getManager().reloadArena(spawn, l1, l2);
                    }
                    if (args[0].equalsIgnoreCase("gamecheck")) {
                        if (ArenaManager.getManager().isInGame(player)) {
                            sender.sendMessage(ChatColor.GREEN + "TRUE");
                        } else {
                            sender.sendMessage(ChatColor.RED + "FALSE");
                        }
                    }
                    if (args[0].equalsIgnoreCase("loadcheck")) {
                        ArenaManager.getManager().loadArenas();
                        sender.sendMessage(ChatColor.GREEN + "DONE");
                    }
                } else {
                    sender.sendMessage("You must be in-game to execute this command!");
                }
            } else {
                sender.sendMessage(ChatColor.RED + "Usage: /arena <args>");
            }
        }
        return false;
    }
}