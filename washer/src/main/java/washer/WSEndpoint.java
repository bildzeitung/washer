package washer;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/")
public class WSEndpoint {
	@OnMessage
    public String onMessage(String message, Session session) {
        return message;
    }
}
