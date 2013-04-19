package tk.rasmase.beer;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BeerCommandExecutor implements CommandExecutor {
    
	private Beer plugin; // pointer to your main class, unrequired if you don't need methods from the main class
 
	public BeerCommandExecutor(Beer plugin) {
		this.plugin = plugin;
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				if (cmd.getName().equalsIgnoreCase("beer")) {
					
					if (args.length > 0) { //If there is more than 0 arguments
						if (args[0].equalsIgnoreCase("help")) { //If argument 1 is help
						giveHelp(sender);
						return true;
						} else if (args[0].equalsIgnoreCase("give")) {
							if (args.length > 1) {
							if(args[1].equalsIgnoreCase("beer")) {
							if (args.length < 2) {
								if (sender instanceof Player) {
									if (sender.hasPermission("beer.give.beer")) {
									giveBeer(sender);
									return true;
								} else {
									sender.sendMessage("You don't have permission to do this!");
									return false;
								}
								} else {
									sender.sendMessage("Don't give beer to the console, it's a violent drinker.");
									return false;
								}
							} else {
								Player target = (plugin.getServer().getPlayer(args[2]));
								if (sender.hasPermission("beer.give.beer")) {
								if (target == null) {
									sender.sendMessage(args[2] + " is not online!");
									return false;
								} else {
									giveBeer(target);
									sender.sendMessage("Gave " +target.getName() + " some beer");
									return true;
									
								}
								} else {
									sender.sendMessage("You do not have permission to do this!");
									return false;
								}
							}
							} else {
								sender.sendMessage("Command usage: /beer give beer [player]");
								return false;
							}
							} else {
								sender.sendMessage("Command usage: /beer give beer [player]");
								return false;
							}
						} else {
							sender.sendMessage("Unknown command! Type /beer help for help.");
							return false;
						}
				} else { //If it's not
					sender.sendMessage("Beer plugin by Rasmase. Type '/beer help' for help");
			return false;
				}
				} else { //If it's not /beer
					return false;
				}
	}
	
	public void giveHelp(CommandSender sender) {
		sender.sendMessage("/beer give beer [user] -Gives you a beer or the user beer");
		sender.sendMessage("/beer help -Shows this");
	}
	
	public void giveBeer(CommandSender sender) {
		Player commandSender = (Player)sender;
		ItemStack beer = new ItemStack(Material.POTION, 3); //Defines beer
    	ItemMeta meta = beer.getItemMeta(); //Get meta something
    	meta.setDisplayName("Beer"); //Sets name
    	meta.setLore(Arrays.asList("Gives slowness and confusion effects."));
    	beer.setItemMeta(meta); //Something meta something
    	commandSender.getInventory().addItem(beer);
	}
	
}