package materialgdx.networking.server;

import com.badlogic.gdx.utils.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import materialgdx.networking.ConnectionInformation;

public class ServerManager implements Disposable {

	private List<Class<?>> types;
	private HashMap<String, GameServer> servers;

	public ServerManager() {
		this.types = new ArrayList<>();
		this.servers = new HashMap<>();
	}

	public void add(String name, ConnectionInformation information) {
		GameServer server = new GameServer(information);
		server.registerTypes(types);
		servers.put(name, server);
	}

	public GameServer get(String name) {
		return servers.get(name);
	}

	public void remove(String name) {
		servers.get(name).stop();
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
		for (GameServer server : servers.values()) {
			server.stop();
		}
	}

}