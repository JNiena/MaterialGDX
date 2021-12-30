package materialgdx.networking;

public class ConnectionInformation {

	private String address;
	private int tcpPort;
	private int udpPort;

	public ConnectionInformation(String address, int tcpPort, int udpPort) {
		this.address = address;
		this.tcpPort = tcpPort;
		this.udpPort = udpPort;
	}

	public ConnectionInformation(String address, int port) {
		this(address, port, port + 1);
	}

	public ConnectionInformation(int tcpPort, int udpPort) {
		this("", tcpPort, udpPort);
	}

	public ConnectionInformation(int port) {
		this("", port);
	}

	public String getAddress() {
		return address;
	}

	public int getTcpPort() {
		return tcpPort;
	}

	public int getUdpPort() {
		return udpPort;
	}

}