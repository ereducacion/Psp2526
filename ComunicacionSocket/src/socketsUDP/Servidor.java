package socketsUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class Servidor {

	public static void main(String[] args) {
	
		int puertoEscucha = 16005;
		int tamagnoBufferPkt = 1024;
	
		DatagramSocket socket= null;
		try {
			
		//	InetAddress origen = Inet4Address.getByName("192.168.1.130");
			InetAddress origen = Inet4Address.getLocalHost();

			socket = new DatagramSocket(puertoEscucha, origen);
			System.out.println("SERVIDOR:");
			System.out.println("\tEscucho por: " + puertoEscucha + " y la ip " + origen.getHostAddress());

			// recibir un paquete
			byte[] bufferTemporal = new byte[tamagnoBufferPkt];
			DatagramPacket paqueteRecibido = new DatagramPacket(bufferTemporal, bufferTemporal.length);
			System.out.println("Esperando datagrama.....");
			
			socket.receive(paqueteRecibido); // se bloquea la ejecución hasta que recibe un paquete
			
			System.out.println("<---RECIBIDO:" + paqueteToString(paqueteRecibido));			 
				
			// construyo un Datagrama para enviar al cliente un mensaje
			// SE QUE PODRÉ ENVIARLE LA INFORMACIÓN PORQUE EN EL PAQUETE ME HA LLEGADO
			// INFORMACIÓN DE CUAL ES EL CANAL POR EL QUE ENVIARLE LOS DATOS
			String mensaje = "que estás haciendo por ahí!";
			DatagramPacket paqueteEnviado = new DatagramPacket(mensaje.getBytes(), mensaje.length(), paqueteRecibido.getAddress(), paqueteRecibido.getPort());
			socket.send(paqueteEnviado);			
			System.out.println("ENVIADO-->:" + paqueteToString(paqueteEnviado));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}
	
	public static String paqueteToString (DatagramPacket paquete) {
		 return ("|" + new String(paquete.getData(), 0, paquete.getLength()) + "|" + paquete.getLength() + "|" + 
				 paquete.getAddress().getHostAddress() + "|" + paquete.getPort() + "|");
	}
}
