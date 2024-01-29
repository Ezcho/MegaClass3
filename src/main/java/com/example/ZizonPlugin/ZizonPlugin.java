package com.example.ZizonPlugin;

import org.bukkit.plugin.java.JavaPlugin;
public class ZizonPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Enable plugin");
    }
    @Override
    public void onDisable() {
        getLogger().info("Disable plugin");
    }
}
