package io.github.psgs.arenaapi;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class Arena {

    int id;
    Location spawn;
    Location l1;
    Location l2;
    List<String> players = new ArrayList<String>();

    /**
     * @param id The arena's ID number
     * @param spawn The arena's spawn location
     * @param l1 The top left location of the arena boundary
     * @param l2 The bottom right location of the arena boundary
     */
    public Arena(int id, Location spawn, Location l1, Location l2) {
        this.id = id;
        this.spawn = spawn;
        this.l1 = l1;
        this.l2 = l2;
    }

    public int getId() {
        return this.id;
    }

    public Location getSpawn() {
        return this.spawn;
    }

    public List getPlayers() {
        return this.players;
    }
}
