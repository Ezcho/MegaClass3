package com.example.ZizonPlugin.Command;

import com.example.ZizonPlugin.ZizonPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class JobCommand implements CommandExecutor {
    private ZizonPlugin plugin;
    public JobCommand(ZizonPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }

        Player player = (Player) sender;
        if (args.length != 1) {
            return false;
        }

        String job = args[0].toLowerCase();
        if (!job.equals("농부") && !job.equals("광부") && !job.equals("사냥꾼")) {
            player.sendMessage(ChatColor.RED + "잘못된 직업입니다. 농부, 광부, 사냥꾼 중에서 선택해주세요.");
            return true;
        }

        plugin.getConfig().set("users." + player.getUniqueId().toString() + ".job", job);
        plugin.saveConfig();
        player.sendMessage(ChatColor.GREEN + "직업 " + job + "을(를) 선택했습니다!");
        return true;
    }
}

