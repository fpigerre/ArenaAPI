ArenaAPI  [![Build Status](https://travis-ci.org/psgs/ArenaAPI.png?branch=master)](https://travis-ci.org/psgs/ArenaAPI)
===========

ArenaAPI is a Bukkit framework designed to make creating arenas in other plugins easy.
Java documentation for this API can be found on [psgs' site](http://psgs.tk/arenaapi).

There are two ways you can incorporate this API in your own code.

#### Adding ArenaAPI as a dependency

The easiest way to incorporate ArenaAPI's functions in your plugin is to add ArenaAPI as a dependency.
This can easily be done using [Apache Maven](http://maven.apache.org).
If you use Apache Maven, simply add the following dependency to your [pom.xml](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) file...

```xml
<dependency>
    <groupId>io.github.psgs</groupId>
    <artifactId>ArenaAPI</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

If you choose to use this method, any servers your plugin will run on will be required to also run ArenaAPI as a standalone plugin.
It is also recommended that you add the following line to your plugin.yml file:

```yaml
depend: [ArenaAPI]
```

#### Incorporating the ArenaAPI package

The other way to use ArenaAPI in your plugin is to incorporate the ArenaAPI package as part of your code.

To do this, simply copy the [```io.github.psgs.arenaapi``` package](https://github.com/psgs/ArenaAPI/tree/master/src/main/java) into the source folder of your own code.
In most cases, this will be the src folder.

Then open up the package and delete the ```ArenaAPI.java``` file.
Finally, open the ```ArenaManager.java``` file.

On [line 15](https://github.com/psgs/ArenaAPI/blob/master/src/main/java/io/github/psgs/arenaapi/ArenaManager.java#L15), you should see the following statement:
```private static ArenaAPI plugin;```

Now change 'ArenaAPI' to the name of your plugin's main class.

Please remember to also copy across the [license]() packaged in this repository.

---

If you'd like to contribute to this plugin, feel free to [open an issue](https://github.com/psgs/ArenaAPI/issues/new) or a [pull request](https://github.com/psgs/ArenaAPI/compare/).

Thankyou xTrollxDudex from bukkit ([Agent Troll on GitHub](https://github.com/AgentTroll/ArenaPVP)) for writing ['[Tutorial] Make a minigame plugin'](https://forums.bukkit.org/threads/tutorial-make-a-minigame-plugin.168164/) and some of the code provided in this plugin.
