package materialgdx.networking;

import com.badlogic.gdx.utils.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NetworkManager implements Disposable {

	private List<Class<?>> types;
	private HashMap<String, GameClient> clients;
	private HashMap<String, GameServer> servers;

	public NetworkManager() {
		types = new ArrayList<>();
		clients = new HashMap<>();
		servers = new HashMap<>();
	}

	public GameClient createClient(String name, ConnectionInformation information) {
		GameClient client = new GameClient(information);
		client.registerTypes(types);
		clients.put(name, client);
		return client;
	}

	public GameServer createServer(String name, ConnectionInformation information) {
		GameServer server = new GameServer(information);
		server.registerTypes(types);
		servers.put(name, server);
		return server;
	}

	public void destroyClient(String name) {
		clients.remove(name).stop();
	}

	public void destroyServer(String name) {
		servers.remove(name).stop();
	}

	public GameClient getClient(String name) {
		return clients.get(name);
	}

	public GameServer getServer(String name) {
		return servers.get(name);
	}

	public void registerTypes(Class<?>... types) {
		for (Class<?> type : types) {
			this.types.add(type);
		}
	}

	@Override
	public void dispose() {
		for (GameClient client : clients.values()) {
			client.stop();
		}
		for (GameServer server : servers.values()) {
			server.stop();
		}
	}

}