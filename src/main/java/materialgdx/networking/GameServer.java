package materialgdx.networking;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;
import java.util.List;
import java.util.function.BiConsumer;

public class GameServer extends GameEndpoint {

	private Server server;
	private EndpointReceiver receiver;

	public GameServer(ConnectionInformation information) {
		super(information);
		server = new Server();
		receiver = new EndpointReceiver(server);
	}

	@Override
	public void start() {
		server.start();
		try {
			server.bind(information.getTcpPort(), information.getTcpPort());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void stop() {
		server.stop();
	}

	@Override
	public void sendTCP(Object data) {
		server.sendToAllTCP(data);
	}

	@Override
	public void sendUDP(Object data) {
		server.sendToAllUDP(data);
	}

	@Override
	public <T> void onReceived(Class<T> type, BiConsumer<Connection, T> handler) {
		receiver.onReceived(type, handler);
	}

	public void registerTypes(List<Class<?>> types) {
		for (Class<?> type : types) {
			server.getKryo().register(type);
		}
	}

}