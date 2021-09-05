package plugin.dev.laarky17.WhiteList.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import plugin.dev.laarky17.WhiteList.EntryPoint;

import java.util.List;

public class Events implements Listener {
    @EventHandler
    private void onJoin(PlayerJoinEvent Event) {
        List<String> WhiteList = EntryPoint.getPInstance().getConfigConfig().getStringList("List");
        Player EntityPlayer = Event.getPlayer();

        if (!WhiteList.contains(EntityPlayer.getDisplayName()))
            EntityPlayer.kickPlayer(ChatColor.RED + "Acesso restrito!");
    }
}
