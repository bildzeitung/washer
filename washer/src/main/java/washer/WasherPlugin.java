/*
 * Washer Plugin
 * 
 * Washer exposes the Spigot API via a WebSocket
 * 
 */
package washer;

import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.World;


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
		WBridge.getInstance().setWasher(this);
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
    
    public void process(WebsocketMessage msg) {
    	log.info("v: " + msg.verb + ", t: " + msg.type);
    	if ((msg.verb.equals("get")) && (msg.type.equals("worlds"))) {
    		String t = "[" + getServer().getWorlds().stream()
    				.map(x -> x.getName())
    				.map(x -> "\"" + x + "\"")
    				.collect(Collectors.joining(",")) + "]";
    		server.sendToClients(t);
    	}
    }
}
