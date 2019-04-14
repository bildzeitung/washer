package washer;

import org.bukkit.util.Vector;

public class WebsocketMessage {
	String verb;
	String type;
	Vector location;

	public WebsocketMessage(String verb, String type, Vector location) { 
		this.verb = verb;
		this.type = type;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "verb: " + verb + ", type: " + type + ", location: " + location.toString();
	}
}
