package washer;

import java.io.IOException;
import java.util.logging.Logger;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/", decoders = { WDecoder.class })
public class WSEndpoint {
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@OnMessage
    public void onMessage(Session session, WebsocketMessage wsm) {
		logger.info("Received " + wsm.toString());
		WasherPlugin plugin = WBridge.getInstance().getServer() ;
		plugin.process(wsm);
    }
	
	@OnOpen
    public void onOpen(Session session) throws IOException {
		logger.info("Adding " + session);
		WBridge.getInstance().addSession(session);
    }
	
	@OnClose
	public void onClose(Session session) throws IOException {
		logger.info("Removing " + session);
		WBridge.getInstance().removeSession(session);
	}
}
