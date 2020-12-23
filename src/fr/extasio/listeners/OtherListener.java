package fr.extasio.listeners;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;


public class OtherListener implements Listener{
public HashMap<String, Long> cooldown= new HashMap<String, Long>();
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
	   Player p = e.getPlayer();
	   cooldown.put(p.getName(), (long) 0);
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
	   Player p = e.getEntity().getPlayer();
	   cooldown.put(p.getName(), (long) 0);
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {

		Player player = e.getPlayer();
		ItemStack it = player.getItemInHand();
		if(it != null && it.getType().equals(Material.ENDER_PEARL)) {
	            if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
	    			int cooldownTime = 10; 
	    		    if(cooldown.containsKey(player.getName())) {
	    		          long secondsLeft = ((cooldown.get(player.getName())/1000)+cooldownTime) - (System.currentTimeMillis()/1000);
	    		          if(secondsLeft > 0) {
	    		              e.setCancelled(true);
	    		              player.sendMessage("§cVous devez patienter encore "+ secondsLeft +" secondes avant d'utiliser une enderpearl.");
	    		          } else {
	    		           cooldown.put(player.getName(), System.currentTimeMillis());
	    		          }
	    		    }
	    		}
	            
		}
	}
}
