package socketsUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) throws InterruptedException {
		
		int puertoServidorDestino = 16005;
		int tamagnoBufferPkt = 1024;
	
		DatagramSocket socket = null;
		try {
			
			// PREPARO EL DESTINO
//			InetAddress destino = Inet4Address.getByName("192.168.1.130");
			InetAddress destino = Inet4Address.getLocalHost(); // en este caso el socket del servidor está en local

			byte[] mensaje = new byte[tamagnoBufferPkt];
			
			String mensajeStr = "Hola que tal?";
			
			// construyo el datagrama que quiero enviar
			// creamos el Datagrama diciendo...
			// el mensaje en bytes // la longitud del mensaje // la máquina de destino // el puerto de destino
			mensaje = mensajeStr.getBytes();
			DatagramPacket paqueteEnv = new DatagramPacket(mensaje, mensaje.length, destino, puertoServidorDestino);
			
			socket = new DatagramSocket(); // no necesito poner nada más porque el paquete ya sabe donde tiene que ir
			System.out.println("CLIENTE:");
			System.out.println("\tEnvio por: " + socket.getLocalPort() + " y la ip " + Inet4Address.getLocalHost().getHostAddress() );
			System.out.println("ENVIANDO -->" + paqueteToString(paqueteEnv));

			socket.send(paqueteEnv);
			
			// SI QUIERO ESCUCHAR UNA RESPUESTA APROVECHO EL SOCKET QUE HE ABIERTO YO MISMA
			byte[] bufferTemporal = new byte[tamagnoBufferPkt];
			DatagramPacket paqueteRecibido = new DatagramPacket(bufferTemporal, bufferTemporal.length);
			System.out.println("Esperando datagrama.....");
			
			socket.setSoTimeout(10);
			socket.receive(paqueteRecibido);
			System.out.println("IP origen:" + paqueteRecibido.getAddress().getHostAddress() + ";Puerto origen:" + paqueteRecibido.getPort());
			System.out.println("<---RECIBIDO:" + paqueteToString(paqueteRecibido));

			
		} catch (IOException e) {
			System.out.println("Error de entrada salida");
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
