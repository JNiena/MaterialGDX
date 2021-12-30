package materialgdx.networking.server;

import com.esotericsoftware.kryonet.Server;

public class ServerSender {

	private Server server;

	public ServerSender(Server server) {
		this.server = server;
	}

	public void sendTCP(Object data) {
		server.sendToAllTCP(data);
	}

	public void sendTCP(int id, Object data) {
		server.sendToTCP(id, data);
	}

	public void sendUDP(Object data) {
		server.sendToAllUDP(data);
	}

	public void sendUDP(int id, Object data) {
		server.sendToUDP(id, data);
	}

}