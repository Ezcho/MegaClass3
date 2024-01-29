package com.example.ZizonPlugin.Listner;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.Action;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RightClickItemListener implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            //플레이어가 공기나, 블럭을 향해 우클릭을 했는지 확인
            Player player = event.getPlayer();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            //플레이어의 인벤토리의 메인hand에 들고있는 item에 대한 item 스택 클래스 생성
            if (itemInHand.getType() == Material.DIAMOND_SWORD) {
                player.sendMessage("this item is DIAMOND_SWORD");
            }
            else{
                Material handItm = itemInHand.getType();
                if(handItm == Material.RED_WOOL) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600, 0));
                }
                else if (handItm == Material.BLUE_WOOL) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 600, 0));
                }
                else if (handItm == Material.YELLOW_WOOL) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 0));
                }
                else if (handItm == Material.BLACK_WOOL) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,600,0));
                }
                else{
                    player.sendMessage("지금 손에들고 있는 아이템은 "+handItm+"입니다.");
                }
            }
        }
    }
}
