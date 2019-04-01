package washer;

import java.util.HashSet;
import java.util.Set;

import javax.websocket.Session;

public class WBridge {
	private static final WBridge INSTANCE = new WBridge();
	public WServer server;
	private static Set<Session> sessions = new HashSet<Session>();
	
	private WBridge() {
		// no public constructors
	}
	
	public static WBridge getInstance() {
		return INSTANCE;
	}

	public void addSession(Session session) {
		sessions.add(session);
	}

	public void removeSession(Session session) {
		sessions.remove(session);
	}
	
	public Set<Session> getSessions() {
		return sessions;
	}
}