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
            Player player = event.getPlayer();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            if (itemInHand.getType() == Material.DIAMOND_SWORD) {
                player.sendMessage("this item is DIAMOND_SWORD");
            }
            else{
                Material handItm = itemInHand.getType();
                if(handItm == Material.RED_WOOL) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600, 0));
                }
                else if (handItm == Material.BLUE_WOOL) {
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.INVISIBILITY, 600, 0);
                    player.addPotionEffect(potionEffect);
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
                System.out.println("안녕하세요");
                System.out.println(1+2);
            }
        }
    }
}