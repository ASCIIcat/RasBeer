package tk.rasmase.beer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrinkListener implements Listener {
	
	private Beer plugin; // pointer to your main class, unrequired if you don't need methods from the main class
	 
	public DrinkListener() {
		this.plugin = plugin;
	}

    @EventHandler
    public void onPlayerDrink(PlayerItemConsumeEvent event) {
        ItemStack item = event.getItem(); //Gets the item that is consumed
        Player player = event.getPlayer(); //Gets player who triggered effect
<<<<<<< HEAD
        if (event.isCancelled() == true || event.getItem() == null) {
        	return;
=======
               if (event.isCancelled() == true || event.getItem() == null) {
         return;
>>>>>>> c07409a94f8f22be36038a1c372c849d1b3fe9e0
        } else if (item.getItemMeta().getDisplayName() == "Beer") { //If the item's name is beer...
        	if(player.hasPermission("beer.beer.drink")) { //Check for permission
        	 player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3000, 1));  //Gives the drinker various effects
        	 player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 3000, 1));
        	 player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 3000, 1));
        	 player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3000, 1));
        	} else {
        		event.setCancelled(true); //cancel drinking
        		player.sendMessage("You don't have permission to drink beer!");
        	}
        } else if (item.getItemMeta().getDisplayName().equals("Ale")) {
        	if(player.hasPermission("beer.ale.drink")) { //Check for permission
           	 player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 3000, 1));  //Gives the drinker various effects
           	 player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 3000, 1));
           	 player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 3000, 1));
           	 player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 3000, 1));
           	} else {
           		event.setCancelled(true); //cancel drinking
           		player.sendMessage("You don't have permission to drink beer!");
        }
    
    	
    }


}
}
