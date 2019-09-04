import java.net.*;
import java.io.*;

public class UDPClient {
	public static void main(String args[]) {
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket();
			byte[] m = args[0].getBytes();
			byte[] recebido = new byte[1000];
			InetAddress aHost = InetAddress.getByName(args[1]);
			int serverPort = 6789;
			DatagramPacket request = new DatagramPacket(m, args[0].length(), aHost, serverPort);
			aSocket.send(request);
			
			DatagramPacket pacoterecebido = new DatagramPacket(recebido,
					recebido.length);
	 
			aSocket.receive(pacoterecebido);
	 
			String sentenca = new String(pacoterecebido.getData());
	 
			System.out.println("Texto recebido do servidor: " + sentenca);
			
		} catch (SocketException e) {
			System.out.println("Socket: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO: " + e.getMessage());
		} finally {
			if (aSocket != null)
				aSocket.close();
		}
		
    }
}
