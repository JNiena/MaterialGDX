package materialgdx.networking.client;

import com.esotericsoftware.kryonet.Client;
import java.io.IOException;
import java.util.List;
import materialgdx.networking.ConnectionInformation;
import materialgdx.networking.Receiver;

public class GameClient {

	private Client client;
	private Receiver receiver;
	private ClientSender sender;
	private ConnectionInformation information;

	public GameClient(ConnectionInformation information) {
		this.information = information;
		this.client = new Client();
		this.receiver = new Receiver(client);
		this.sender = new ClientSender(client);
	}

	public void start() {
		client.start();
		try {
			client.connect(1000, information.getAddress(), information.getTcpPort(), information.getTcpPort());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void stop() {
		client.stop();
	}

	public ClientSender getSender() {
		return sender;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void registerTypes(List<Class<?>> types) {
		for (Class<?> type : types) {
			client.getKryo().register(type);
		}
	}

	public void registerTypes(Class<?>... types) {
		for (Class<?> type : types) {
			client.getKryo().register(type);
		}
	}

}