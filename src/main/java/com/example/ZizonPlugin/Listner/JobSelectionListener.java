package com.example.ZizonPlugin.Listner;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JobSelectionListener extends JavaPlugin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = this.getConfig();
        // 이미 직업을 선택했다면 메시지를 보여주지 않음
        if (config.contains("users." + player.getUniqueId().toString() + ".job")) {
            return;
        }
        // 직업 선택 안내 메시지
        player.sendMessage(ChatColor.GREEN + "직업을 선택해주세요. 명령어: /job <농부|광부|사냥꾼>");
    }


}