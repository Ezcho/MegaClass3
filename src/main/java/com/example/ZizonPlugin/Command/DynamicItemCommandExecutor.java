package com.example.ZizonPlugin.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DynamicItemCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("getitem")) {
                if (args.length > 0) {
                    Material material = Material.matchMaterial(args[0].toUpperCase());

                    if (material != null) {
                        ItemStack itemStack = new ItemStack(material);
                        player.getInventory().addItem(itemStack);
                        player.sendMessage("당신은 " + material.name() + "을 겟 했습니다.");
                    } else {
                        player.sendMessage("유효하지 않은 아이템입니다.");
                    }
                    return true;
                } else {
                    player.sendMessage("사용법: /getitem <아이템 이름>");
                }
            }
        } else {
            sender.sendMessage("이 명령어는 플레이어만 사용할 수 있습니다.");
        }
        return false;
    }
}
