package materialgdx.networking;

import com.esotericsoftware.kryonet.Connection;
import java.util.function.BiConsumer;

public abstract class GameEndpoint implements Sender, Receiver {

	protected ConnectionInformation information;

	public GameEndpoint(ConnectionInformation information) {
		this.information = information;
	}

	public abstract void start();

	public abstract void stop();

	@Override
	public abstract void sendTCP(Object data);

	@Override
	public abstract void sendUDP(Object data);

	@Override
	public abstract <T> void onReceived(Class<T> type, BiConsumer<Connection, T> handler);

}