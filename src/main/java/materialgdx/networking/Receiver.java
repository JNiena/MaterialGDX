package materialgdx.networking;

import com.esotericsoftware.kryonet.Connection;
import java.util.function.BiConsumer;

public interface Receiver {

	public <T> void onReceived(Class<T> type, BiConsumer<Connection, T> handler);

}