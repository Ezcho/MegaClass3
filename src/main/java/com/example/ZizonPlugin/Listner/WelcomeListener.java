package com.example.ZizonPlugin.Listner;
import com.example.ZizonPlugin.ZizonPlugin;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class WelcomeListener implements Listener {
    private ZizonPlugin plugin;

    public WelcomeListener(ZizonPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("환영합니다, " + player.getName() + "!");
        if (!plugin.getConfig().contains("users." + event.getPlayer().getUniqueId().toString() + ".job")) {
            event.getPlayer().sendMessage(ChatColor.GREEN + "직업을 선택해주세요. 명령어: /job <농부|광부|사냥꾼>");
        }
    }
}
