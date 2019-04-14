package washer;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

public class WDecoder implements Decoder.Text<WebsocketMessage> {
	private static Gson gson = new Gson();
	
	@Override
	public void init(EndpointConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebsocketMessage decode(String s) throws DecodeException {
		return gson.fromJson(s, WebsocketMessage.class);
	}

	@Override
	public boolean willDecode(String s) {
		return (s != null);
	}

}
