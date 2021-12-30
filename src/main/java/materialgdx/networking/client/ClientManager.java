package materialgdx.networking.client;

import com.badlogic.gdx.utils.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import materialgdx.networking.ConnectionInformation;

public class ClientManager implements Disposable {

	private List<Class<?>> types;
	private HashMap<String, GameClient> clients;

	public ClientManager() {
		this.types = new ArrayList<>();
		this.clients = new HashMap<>();
	}

	public void add(String name, ConnectionInformation information) {
		GameClient client = new GameClient(information);
		client.registerTypes(types);
		clients.put(name, client);
	}

	public GameClient get(String name) {
		return clients.get(name);
	}

	public void remove(String name) {
		clients.get(name).stop();
	}

	public void registerTypes(List<Class<?>> types) {
		this.types.addAll(types);
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
	}

}