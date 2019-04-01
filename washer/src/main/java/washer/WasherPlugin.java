/*
 * Washer Plugin
 * 
 * Washer exposes the Spigot API via a WebSocket
 * 
 */
package washer;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

/* WasherPlugin
 * 
 * A Bukkit plugin that initialises a Tyrus Websocket Server
 */
public class WasherPlugin extends JavaPlugin {
	private Logger log;
	private WServer server;
	
	public WasherPlugin() {
		log = getLogger();
		server = new WServer();
	}
	
    @Override
    public void onEnable() {
    	WListener w = new WListener(log, server);
    	getServer().getPluginManager().registerEvents(w, this);
    	
    	try {
    		server.run();
    	} catch (Exception e) {
    		log.info(e.getMessage());
    		e.printStackTrace();
    	}
    }
 
    @Override
    public void onDisable() {
    	server.stop();
    }
}
