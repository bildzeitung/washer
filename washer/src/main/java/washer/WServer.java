package washer;

import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.Session;

import org.glassfish.tyrus.server.Server;


/*
 * WServer
 * 
 * A Tyrus standalone (Grizzly) Websocket server
 * 
 */
public class WServer {
	private static int PORT = 1234;
	private Server server;
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public void run() throws Exception {
		server = new Server("localhost", WServer.PORT, "/", null, WSEndpoint.class);
		server.start();
	}
	
	public void stop() {
		server.stop();
	}
	
	public void sendToClients(String msg) {
		for (Session s: WBridge.getInstance().getSessions()) {
			try {
				s.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				logger.info(e.toString());
			}
		}
	}
}
