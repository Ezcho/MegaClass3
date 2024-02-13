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
        //   /getitem, 이때 command.getName 은 tp 이고, auser와 buser는 각각 args[0]과 args[1]이다.
        if (sender instanceof Player) { //플레이어에게서 명령어 수행
            Player player = (Player) sender;//sender를 보낸 player를 player라고 선언
            if (command.getName().equalsIgnoreCase("getitem")) {    //command의 명령어가 getitem인지 확인
                if (args.length > 0) {  //두번째 argument가 0보다 크다면..
                    Material material = Material.matchMaterial(args[0].toUpperCase());
                    //arg[0]을 material객체로 선언
                    if (material != null) { //null이아니면
                        ItemStack itemStack = new ItemStack(material,10);  //meterial itemstack을 지정
                        player.getInventory().addItem(itemStack);
                        player.sendMessage("당신은 " + material.name() + "을 겟 했습니다.");
                    }
                    else {
                        player.sendMessage("유효하지 않은 아이템입니다.");
                    }
                    return true;
                }
                else {
                    player.sendMessage("사용법: /getitem <아이템 이름>");
                }
            }
        }
        else {
            sender.sendMessage("이 명령어는 플레이어만 사용할 수 있습니다.");
        }
        return false;
    }
}
