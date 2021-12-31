package materialgdx.networking;

public interface Sender {

	public void sendTCP(Object data);

	public void sendUDP(Object data);

}