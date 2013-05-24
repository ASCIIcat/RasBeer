package tk.rasmase.beer;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Beer extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
    	
    	//Generate Config
        if (!new File(getDataFolder(), "config.yml").exists()) { //If the config dont exists...
            getLogger().info("Generating Default Config"); //Say this.
            saveDefaultConfig(); //Generate Config...
            getLogger().info("Default Config Generated"); //Say This...
            }
        //Generate Config 
        
        FileConfiguration config = getConfig();
        List<String> drinksKeys = new ArrayList<String>();
        
        for(String key : config.getKeys(false))
        {
        	drinksKeys.add(key);
        }
        
        for (String key : drinksKeys) 
        {
			if(key.equals("db"))
				break;
			
			//Sets beer
	    	ItemStack drink = new ItemStack(Material.POTION, 3); //Defines beer
	    	ItemMeta meta = drink.getItemMeta(); //Get meta something
	    	meta.setDisplayName(config.getString(key)); //Sets name
	    	meta.setLore(Arrays.asList(config.getString(key+".DrinkLore"))); //Sets Desc
	    	drink.setItemMeta(meta); //Something meta something
	    	//Sets Beer
	    	
	    	//Sets Recipe
	        ShapedRecipe Drink = new ShapedRecipe(drink); //Creates a recipe for beer
	        Drink.shape(config.getString(key+".line1"), config.getString(key+".line2"), config.getString(key+".line3")); //Sets the shape for beer
	        if (!config.getString(key+".Material1").equals("")) {
	        	Drink.setIngredient(config.getString(key+".Material1Name").charAt(0), Material.matchMaterial(config.getString(key+".Material1"))); //Sets ingredients
	        }
	        if (!config.getString(key+".Material2").equals("")) {
	        	Drink.setIngredient(config.getString(key+".Material2Name").charAt(0), Material.matchMaterial(config.getString(key+".Material2")));
	           }
	        if (!config.getString(key+".Material3").equals("")) {
	        	Drink.setIngredient(config.getString(key+".Material3Name").charAt(0), Material.matchMaterial(config.getString(key+".Material3")));
	           }
	        Bukkit.getServer().addRecipe(Drink);  //Adds the recipe to server
	        getLogger().info("RasBeer Recipe added:"+config.getString(key+".DrinkName"));
	        //Sets Recipe
		}
        
        
        //Listeners
        getServer().getPluginManager().registerEvents(new CraftListener(), this);
        getServer().getPluginManager().registerEvents(new DrinkListener(), this);
        getServer().getPluginManager().registerEvents(new signListener(), this);
        getCommand("beer").setExecutor(new BeerCommandExecutor(this)); //Impements CommandExecutor
        //Listeners
        
        
    }
    
    @Override
    public void onDisable(){
    	//Might do something in the future
    }
    
}
