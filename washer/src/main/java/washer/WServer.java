package washer;

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

	public void run() throws Exception {
		server = new Server("localhost", WServer.PORT, "/", null, WSEndpoint.class);
		server.start();
	}
	
	public void stop() {
		server.stop();
	}
}
