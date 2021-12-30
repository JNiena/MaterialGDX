package materialgdx.networking.server;

import com.esotericsoftware.kryonet.Server;
import java.io.IOException;
import java.util.List;
import materialgdx.networking.ConnectionInformation;
import materialgdx.networking.Receiver;

public class GameServer {

	private Server server;
	private Receiver receiver;
	private ServerSender sender;
	private ConnectionInformation information;

	public GameServer(ConnectionInformation information) {
		this.information = information;
		this.server = new Server();
		this.receiver = new Receiver(server);
		this.sender = new ServerSender(server);
	}

	public void start() {
		server.start();
		try {
			server.bind(information.getTcpPort(), information.getTcpPort());
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void stop() {
		server.stop();
	}

	public ServerSender getSender() {
		return sender;
	}

	public Receiver getReceiver() {
		return receiver;
	}

	public void registerTypes(List<Class<?>> types) {
		for (Class<?> type : types) {
			server.getKryo().register(type);
		}
	}

	public void registerTypes(Class<?>... types) {
		for (Class<?> type : types) {
			server.getKryo().register(type);
		}
	}

}