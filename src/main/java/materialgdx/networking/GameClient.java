package materialgdx.networking;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import java.io.IOException;
import java.util.List;
import java.util.function.BiConsumer;

public class GameClient extends GameEndpoint {

	private Client client;
	private EndpointReceiver receiver;

	public GameClient(ConnectionInformation information) {
		super(information);
		client = new Client();
		receiver = new EndpointReceiver(client);
	}

	@Override
	public void start() {
		client.start();
		try {
			client.connect(1000, information.getAddress(), information.getTcpPort(), information.getTcpPort());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void stop() {
		client.stop();
	}

	@Override
	public void sendTCP(Object data) {
		client.sendTCP(data);
	}

	@Override
	public void sendUDP(Object data) {
		client.sendUDP(data);
	}

	@Override
	public <T> void onReceived(Class<T> type, BiConsumer<Connection, T> handler) {
		receiver.onReceived(type, handler);
	}

	public void registerTypes(List<Class<?>> types) {
		for (Class<?> type : types) {
			client.getKryo().register(type);
		}
	}

}