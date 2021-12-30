package materialgdx.networking;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.EndPoint;
import com.esotericsoftware.kryonet.Listener;
import java.util.HashMap;
import java.util.function.BiConsumer;

public class Receiver {

	private HashMap<Class<?>, BiConsumer<Connection, Object>> handlers;

	public Receiver(EndPoint endPoint) {
		this.handlers = new HashMap<>();
		endPoint.addListener(new Listener() {
			@Override
			public void received(Connection connection, Object object) {
				for (Class<?> type : handlers.keySet()) {
					if (type.isAssignableFrom(object.getClass())) {
						handlers.get(type).accept(connection, object);
						break;
					}
				}
			}
		});
	}

	public void onReceived(Class<?> type, BiConsumer<Connection, Object> handler) {
		handlers.put(type, handler);
	}

}