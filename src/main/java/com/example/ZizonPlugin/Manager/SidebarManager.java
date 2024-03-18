package com.example.ZizonPlugin.Manager;

import com.example.ZizonPlugin.ZizonPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class SidebarManager {

    private ZizonPlugin plugin;

    public SidebarManager(ZizonPlugin plugin) {
        this.plugin = plugin;
    }

    public void setPlayerSidebar(Player player) {
        FileConfiguration config = plugin.getConfig();

        ScoreboardManager manager = Bukkit.getScoreboardManager();

        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("sidebar", "dummy", ChatColor.GREEN + "플레이어 정보");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score nameScore = objective.getScore(ChatColor.WHITE + "이름: " + ChatColor.YELLOW + player.getName());
        nameScore.setScore(2);

        String job = config.getString("users." + player.getUniqueId().toString() + ".job", "직업 없음");
        Score jobScore = objective.getScore(ChatColor.WHITE + "직업: " + ChatColor.YELLOW + job);
        jobScore.setScore(1);

        player.setScoreboard(scoreboard);
    }
}
