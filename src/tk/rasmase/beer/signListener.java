package tk.rasmase.beer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class signListener implements Listener {

	private Beer plugin; // pointer to your main class, unrequired if you don't need methods from the main class
	 
	public signListener() {
		this.plugin = plugin;
	}
	
    @EventHandler
    public void onSignChange(SignChangeEvent event) {
    		if (event.getLine(0).toString().equalsIgnoreCase("[beer]")) {
    			if (event.getPlayer().hasPermission("beer.beer.keg")) {
    			if (event.getLine(1).equals("")) {
    				String toAdd = String.valueOf(event.getBlock().getX()) + ", " + String.valueOf(event.getBlock().getY()) + ", " + String.valueOf(event.getBlock().getZ()) + ", 0";
    				//plugin.getConfig().set("kegs", plugin.getConfig().getStringList("kegs").add(toAdd));
    				List dkegs = plugin.getConfig().getList("db.kegs");
    				dkegs.add(toAdd);
    			    plugin.getConfig().set("db.kegs", dkegs);
    				plugin.saveConfig();
    				event.getPlayer().sendMessage("You just created a beer keg!");
    			}
    		} else {
    		}
    	      
    		}
    }
}
