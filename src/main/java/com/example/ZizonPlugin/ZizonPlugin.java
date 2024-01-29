package com.example.ZizonPlugin;

import com.example.ZizonPlugin.Command.DynamicItemCommandExecutor;
import com.example.ZizonPlugin.Listner.RightClickItemListener;
import com.example.ZizonPlugin.Listner.WelcomeListener;
import org.bukkit.plugin.java.JavaPlugin;
public class ZizonPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Enable plugin");
        getServer().getPluginManager().registerEvents(new WelcomeListener(), this);
        getServer().getPluginManager().registerEvents(new RightClickItemListener(), this);
        this.getCommand("getitem").setExecutor(new DynamicItemCommandExecutor());
    }
    @Override
    public void onDisable() {
        getLogger().info("Disable plugin");
    }
}
