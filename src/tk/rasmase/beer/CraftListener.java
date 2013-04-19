package tk.rasmase.beer;

import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {

    @EventHandler
	public void onPlayerCraft(CraftItemEvent event) {
    	HumanEntity human =  event.getView().getPlayer();

    	if(human instanceof Player) {
    	    Player brewer = (Player)human;
        	if (event.getRecipe().getResult().getItemMeta().getDisplayName().equals("Beer")) {
        		if (brewer.hasPermission("beer.beer.brew")) {
        			//Let him craft
        			
        		} else {
        			brewer.sendMessage("You don't have permission to brew beer!");
                    brewer.setItemOnCursor(null);
                    brewer.getInventory().addItem(new ItemStack(Material.POTION, 3));
                    brewer.getInventory().addItem(new ItemStack(Material.SEEDS, 3));
        		}
        		
        	}
    	}

    }
}
