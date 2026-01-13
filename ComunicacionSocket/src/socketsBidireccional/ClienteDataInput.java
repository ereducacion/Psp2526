package socketsBidireccional;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * ESTA CLASE ES UNA PRUEBA BIDIRECCIONAL
 * ES EL SERVIDOR
 * 
 * PRIMERO VA A ESCRIBIR Y DESPUÉS VA A LEER
 */
public class ClienteDataInput {
	
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6000;
		
		// creamos el socket
		try {
			Socket misocket = new Socket(host, puerto);
				
		// preparo el sitio donde escribiré en el socket
			OutputStream escrituraSocket = misocket.getOutputStream();
			DataOutputStream escribirAlServidor = new DataOutputStream(escrituraSocket);
		
		// envío algo al servidor
			escribirAlServidor.writeUTF("Hola Servidor!!");
			escribirAlServidor.flush();
			
		// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = misocket.getInputStream();
			DataInputStream leerDelServidor = new DataInputStream(lecturaSocket);
			System.out.println("He leído del servidor=>" + leerDelServidor.readUTF());

			
		// cerrar todos los streams y sockets
			leerDelServidor.close();
			escribirAlServidor.close();
			misocket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
