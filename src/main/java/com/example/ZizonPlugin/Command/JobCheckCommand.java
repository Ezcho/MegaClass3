package com.example.ZizonPlugin.Command;


import com.example.ZizonPlugin.ZizonPlugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JobCheckCommand implements CommandExecutor {

    private ZizonPlugin plugin;
    public JobCheckCommand(ZizonPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            //플레이어 인지 아닌지 확인
            sender.sendMessage(ChatColor.RED + "이 명령어는 플레이어만 사용할 수 있습니다.");
            return true;
        }
        Player player = (Player) sender;
        String path = "users." + player.getUniqueId().toString() + ".job";
        if (plugin.getConfig().contains(path)) {
            String job = plugin.getConfig().getString(path);
            player.sendMessage(ChatColor.GREEN + "당신의 현재 직업은 " + job + "입니다.");
        }
        else {
            player.sendMessage(ChatColor.RED + "아직 직업을 선택하지 않았습니다. '/job <농부|광부|사냥꾼>' 명령어로 직업을 선택해주세요.");
        }
        return true;
    }
}
