package com.example.ZizonPlugin;

import com.example.ZizonPlugin.Command.DynamicItemCommandExecutor;
import com.example.ZizonPlugin.Command.JobCheckCommand;
import com.example.ZizonPlugin.Command.JobCommand;
import com.example.ZizonPlugin.Listner.JobSelectionListener;
import com.example.ZizonPlugin.Listner.RightClickItemListener;
import com.example.ZizonPlugin.Listner.WelcomeListener;
import org.bukkit.plugin.java.JavaPlugin;
public class ZizonPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("Enable plugin");
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new WelcomeListener(this), this);
        this.getCommand("job").setExecutor(new JobCommand(this));
        this.getCommand("jobcheck").setExecutor(new JobCheckCommand(this));
        getLogger().info("JobPlugin 활성화됨!");

        getServer().getPluginManager().registerEvents(new RightClickItemListener(), this);
        this.getCommand("getitem").setExecutor(new DynamicItemCommandExecutor());
    }
    @Override
    public void onDisable() {
        getLogger().info("Disable plugin");
    }
}
