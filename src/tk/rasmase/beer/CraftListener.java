package tk.rasmase.beer;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {
	
	private Beer plugin; // pointer to your main class, unrequired if you don't need methods from the main class
	 
	public CraftListener() {
		this.plugin = plugin;
	}

    @EventHandler
	public void onPlayerCraft(CraftItemEvent event) {
    	HumanEntity human =  event.getView().getPlayer();

    	if(human instanceof Player) {
    	    Player brewer = (Player)human;
        	if (event.getRecipe().getResult().getItemMeta().getDisplayName().equals("Beer") ) {
        		if (brewer.hasPermission("beer.beer.brew")) {
        		//Let him craft
        		} else {
        			brewer.sendMessage("You don't have permission to brew beer!");
                    brewer.setItemOnCursor(null);
                    brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("beer.Material1"))));
                    brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("beer.Material2"))));
                    brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("beer.Material3"))));
        		}
        			
        		} else if (event.getRecipe().getResult().getItemMeta().getDisplayName().equals("Ale") ) {
            		if (brewer.hasPermission("beer.ale.brew")) {
                		//Let him craft
                		} else {
                			brewer.sendMessage("You don't have permission to brew ale!");
                            brewer.setItemOnCursor(null);
                            brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("ale.Material1"))));
                            brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("ale.Material2"))));
                            brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("ale.Material3"))));
                		}
        		
        		}
        		
        	}
    	}

    }
