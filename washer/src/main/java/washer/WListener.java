package washer;

import java.lang.reflect.Type;
import java.util.logging.Logger;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;


public class WListener implements Listener {
	private Logger log;
	private WServer server;
	private Gson gson;
		
	private class PlayerMoveEventSerializer implements JsonSerializer<PlayerMoveEvent> {
		public JsonElement serialize(PlayerMoveEvent src, Type typeofsrc, JsonSerializationContext context) {
			FromToPrimitive ftp = new FromToPrimitive()
					.setFrom(src.getFrom().toVector())
					.setTo(src.getTo().toVector())
					.setPlayer(src.getPlayer().getName());
			
			return context.serialize(ftp);
		}
	}
	
	public WListener(Logger log, WServer server) {
		this.log = log;
		this.server = server;
		GsonBuilder g = new GsonBuilder();
		g.registerTypeAdapter(PlayerMoveEvent.class, new PlayerMoveEventSerializer());
		this.gson = g.create();
	}

	@EventHandler
	public void onPlayerEvent(PlayerMoveEvent event) {
		// only do location changes, not viewpoint changes
		if (event.getFrom().toVector().equals(event.getTo().toVector())) {
			return;
		}
		String s = gson.toJson(event);
		log.info("Received a PlayerMoveEvent" + s);
		server.sendToClients(s);
	}
}
