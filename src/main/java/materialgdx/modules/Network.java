package materialgdx.modules;

import com.badlogic.gdx.utils.Disposable;
import materialgdx.networking.NetworkManager;

public class Network implements Disposable {

	private NetworkManager networkManager;

	public Network() {
		this.networkManager = new NetworkManager();
	}

	public NetworkManager getNetworkManager() {
		return networkManager;
	}

	@Override
	public void dispose() {
		networkManager.dispose();
	}

}