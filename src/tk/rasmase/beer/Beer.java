package tk.rasmase.beer;

import java.io.File;
import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Beer extends JavaPlugin implements Listener {

    @Override
    public void onEnable(){
    	
    	//Generate Config
        if (!new File(getDataFolder(), "config.yml").exists()) { //If the config exists...
            getLogger().info("Generating Default Config"); //Say this.
            saveDefaultConfig(); //Generate Config...
            getLogger().info("Default Config Generated"); //Say This...
            }
        //Generate Config 
        
        //Sets beer
    	ItemStack beer = new ItemStack(Material.POTION, 3); //Defines beer
    	ItemMeta meta = beer.getItemMeta(); //Get meta something
    	meta.setDisplayName("Beer"); //Sets name
    	meta.setLore(Arrays.asList("Gives slowness and confusion effects.")); //Sets Desc
    	beer.setItemMeta(meta); //Something meta something
    	//Sets Beer
    	
    	//Sets Recipe
        ShapedRecipe Beer = new ShapedRecipe(beer); //Creates a recipe for beer
        Beer.shape(getConfig().getString("beer.line1"), getConfig().getString("beer.line2"), getConfig().getString("beer.line3")); //Sets the shape for beer
        if (!getConfig().getString("beer.Material1").equals("")) {
       	 Beer.setIngredient(getConfig().getString("beer.Material1Name").charAt(0), Material.matchMaterial(getConfig().getString("beer.Material1"))); //Sets ingredients
        }
        if (!getConfig().getString("beer.Material2").equals("")) {
        	Beer.setIngredient(getConfig().getString("beer.Material2Name").charAt(0), Material.matchMaterial(getConfig().getString("beer.Material2")));
           }
        if (!getConfig().getString("beer.Material3").equals("")) {
        	Beer.setIngredient(getConfig().getString("beer.Material3Name").charAt(0), Material.matchMaterial(getConfig().getString("beer.Material3")));
           }
        Bukkit.getServer().addRecipe(Beer);  //Adds the recipe to server
        //Sets Recipe
        
        //Listeners
        getServer().getPluginManager().registerEvents(new CraftListener(), this);
        getServer().getPluginManager().registerEvents(new DrinkListener(), this);
        getCommand("beer").setExecutor(new BeerCommandExecutor(this)); //Impements CommandExecutor
        //Listeners
        
        
    }
    
    @Override
    public void onDisable(){
    	//Might do something in the future
    }
    
}
