package com.example.ZizonPlugin;

import com.example.ZizonPlugin.Command.DynamicItemCommandExecutor;
import com.example.ZizonPlugin.Command.JobCheckCommand;
import com.example.ZizonPlugin.Command.JobCommand;
import com.example.ZizonPlugin.Listner.PlayerJoinListener;
import com.example.ZizonPlugin.Listner.RightClickItemListener;
import com.example.ZizonPlugin.Listner.WelcomeListener;
import org.bukkit.plugin.java.JavaPlugin;


public class ZizonPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Enable plugin");

        this.saveDefaultConfig();

        this.getCommand("job").setExecutor(new JobCommand(this));
        this.getCommand("jobcheck").setExecutor(new JobCheckCommand(this));
        this.getCommand("getitem").setExecutor(new DynamicItemCommandExecutor());

        getServer().getPluginManager().registerEvents(new WelcomeListener(this), this);
        getServer().getPluginManager().registerEvents(new RightClickItemListener(), this);

        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this), this);

        getLogger().info("JobPlugin 활성화됨!");
    }
    @Override
    public void onDisable() {
        getLogger().info("Disable plugin");
    }
}
