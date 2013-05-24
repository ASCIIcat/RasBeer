package tk.rasmase.beer;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener 
{
	
	private Beer plugin; // pointer to your main class, unrequired if you don't need methods from the main class
	 
	public CraftListener() {
		this.plugin = plugin;
	}

    @EventHandler
	public void onPlayerCraft(CraftItemEvent event) 
    {
    	HumanEntity human =  event.getView().getPlayer();
    	FileConfiguration config = plugin.getConfig();
        List<String> drinksKeys = new ArrayList<String>();
        
        for(String key : config.getKeys(false))
        {
        	drinksKeys.add(key);
        }
        
        

    	if(human instanceof Player) 
    	{
    	    Player brewer = (Player)human;
    	    if (event.getRecipe().getResult().getType() == Material.POTION) 
    	    {
	        	if (drinksKeys.contains(event.getRecipe().getResult().getItemMeta().getDisplayName() )) 
	        	{
	        		if (brewer.hasPermission("beer.brew")) 
	        		{
	        		//Let him craft
	        		} 
	        		else 
	        		{
	        			brewer.sendMessage("You don't have permission to brew!");
	                    brewer.setItemOnCursor(null);
	                    brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("beer.Material1"))));
	                    brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("beer.Material2"))));
	                    brewer.getInventory().addItem(new ItemStack(Material.matchMaterial(plugin.getConfig().getString("beer.Material3"))));
	        		}
	        			
	        	}
	        	else 
	        	{
	        		return;
	        	}
    	    } 
    	    	else 
    	    	{
    	    		return;
    	    	}
        		
        }
    }

}
