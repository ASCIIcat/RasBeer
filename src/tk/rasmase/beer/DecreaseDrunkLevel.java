package tk.rasmase.beer;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class DecreaseDrunkLevel extends BukkitRunnable {

    private final JavaPlugin plugin;
    
    public DecreaseDrunkLevel(JavaPlugin plugin) {
        this.plugin = plugin;
    }
 
    public void run() {
        // What you want to schedule goes here
    	//player.setMetadata(drunkLevel,new FixedMetadataValue(plugin,value));
    }
 
}