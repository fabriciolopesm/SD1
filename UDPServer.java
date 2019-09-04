import java.net.*;
import java.io.*;
public class UDPServer{
	public static void main(String args[]){ 
	DatagramSocket aSocket = null;
	    try{
	    	aSocket = new DatagramSocket(6789);
		byte[] buffer = new byte[1000];
		byte[] enviar = new byte[1000];
 		while(true){
 		    DatagramPacket request = new DatagramPacket(buffer, buffer.length);
  		    aSocket.receive(request);
  		    System.out.println("Request: " + new String(request.getData()));
  		    InetAddress aHost = request.getAddress();
  		    int serverPort = request.getPort();
  		    String send = new String(request.getData());
  		    enviar = send.getBytes();
  		    DatagramPacket sendPacket = new DatagramPacket(enviar,
					enviar.length, aHost, serverPort);
  		    aSocket.send(sendPacket);
		}
	    }catch (SocketException e){System.out.println("Socket: " + e.getMessage());
	   }catch (IOException e) {System.out.println("IO: " + e.getMessage());}
	finally {if(aSocket != null) aSocket.close();}
	    
		
		
    }
}
