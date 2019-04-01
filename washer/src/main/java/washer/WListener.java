package washer;

import java.util.logging.Logger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.google.gson.Gson;


public class WListener implements Listener {
	private Logger log;
	private WServer server;
	private Gson gson = new Gson();
	
	public WListener(Logger log, WServer server) {
		this.log = log;
		this.server = server;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		log.info("Received a PlayerJoinEvent");
		String s = gson.toJson(event.getPlayer().serialize());
		server.sendToClients(s);
	}
}
