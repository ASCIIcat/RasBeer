package tk.rasmase.beer;

import java.util.HashMap;
import java.util.List;

import javax.xml.bind.Marshaller.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerJoinListener extends Listener {
	
    private final JavaPlugin plugin;
    
    public PlayerJoinListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		//player.setMetadata("drunkLevel", 0, plugin);
	}
}
