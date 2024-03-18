package com.example.ZizonPlugin.Listner;

import com.example.ZizonPlugin.Manager.SidebarManager;
import com.example.ZizonPlugin.ZizonPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private SidebarManager sidebarManager;

    public PlayerJoinListener(ZizonPlugin plugin) {
        this.sidebarManager = new SidebarManager(plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        //config 나 db에 정보를 저장.
        //config 에서 처음 들어온 친구인지 아닌지 조회할 수 있지.
        //Player player = event.getPlayer();
        //player.getUniqueId().toString() 한 다음에
        //이 값으로 config에 조회를 해서, 이 친구가 처음 들어온지 아닌지 혹은 직업이 있는지
        if(//플레이어가 처음 접속했다면..){
            //직업 고르는 클래스.함수 로 이동.
        }
        else(//처음접속이 아니라면..){
            //sidebarManager.setPlayerSidebar(event.getPlayer());
        }
    }
}
