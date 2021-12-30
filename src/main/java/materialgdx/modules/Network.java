package materialgdx.modules;

import com.badlogic.gdx.utils.Disposable;
import materialgdx.networking.client.ClientManager;
import materialgdx.networking.server.ServerManager;

public class Network implements Disposable {

	private ClientManager clientManager;
	private ServerManager serverManager;

	public Network() {
		this.clientManager = new ClientManager();
		this.serverManager = new ServerManager();
	}

	public ClientManager getClientManager() {
		return clientManager;
	}

	public ServerManager getServerManager() {
		return serverManager;
	}

	@Override
	public void dispose() {
		clientManager.dispose();
		serverManager.dispose();
	}

}