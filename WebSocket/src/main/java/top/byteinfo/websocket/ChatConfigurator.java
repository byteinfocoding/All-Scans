package top.byteinfo.websocket;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
//@Component
public class ChatConfigurator extends ServerEndpointConfig.Configurator {
    public static String HEADER_NAME = "X-Real-IP";

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        try {
            String firstFoundHeader = request.getHeaders().get(HEADER_NAME.toLowerCase()).get(0);
            sec.getUserProperties().put(HEADER_NAME, firstFoundHeader);
        } catch (Exception e) {
            sec.getUserProperties().put(HEADER_NAME, "未知ip");
        }
    }
}
