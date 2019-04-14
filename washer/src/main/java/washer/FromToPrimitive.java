package washer;

import org.bukkit.util.Vector;

public class FromToPrimitive {
	public Vector from;
	public Vector to;
	public String player;
	
	public FromToPrimitive setFrom(Vector f) {
		this.from = f;
		return this;
	}
	
	public FromToPrimitive setTo(Vector f) {
		this.to = f;
		return this;
	}
	
	public FromToPrimitive setPlayer(String s) {
		this.player = s;
		return this;
	}
}
