package materialgdx.networking.client;

import com.esotericsoftware.kryonet.Client;

public class ClientSender {

	private Client client;

	public ClientSender(Client client) {
		this.client = client;
	}

	public void sendTCP(Object data) {
		client.sendTCP(data);
	}

	public void sendUDP(Object data) {
		client.sendUDP(data);
	}

}