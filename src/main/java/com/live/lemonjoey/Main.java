package com.live.lemonjoey;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class Main extends JavaPlugin {

    public static Main plugin;
    public static YamlConfiguration message;

    @Override
    public void onEnable() {
        // Plugin startup logic

        plugin = this;
        getServer().getLogger().info("Random teleporter has initiated.");
        Objects.requireNonNull(this.getCommand("wild")).setExecutor(new wildcmd());
        Objects.requireNonNull(this.getCommand("wild")).setTabCompleter(new tabComplete());

        reloadMessages();

        File configyml = new File(plugin.getDataFolder() + File.separator + "config.yml");
        if (!configyml.exists()) {
            plugin.saveResource("config.yml", false);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getServer().getLogger().info("Random teleporter has stopped.");
    }

    public void reloadMessages() {

        File messagesyml = new File(plugin.getDataFolder() + File.separator + "messages.yml");
        if(messagesyml.exists()) {
            message = YamlConfiguration.loadConfiguration(messagesyml);
        } else {
            plugin.saveResource("messages.yml", false);
        }

    }

}


