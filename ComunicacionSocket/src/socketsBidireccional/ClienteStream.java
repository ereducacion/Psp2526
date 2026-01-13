package socketsBidireccional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * ESTA CLASE ES UNA PRUEBA BIDIRECCIONAL
 * ES EL SERVIDOR
 * 
 * PRIMERO VA A ESCRIBIR Y DESPUÉS VA A LEER
 */
public class ClienteStream {
	
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6000;
		
		// creamos el socket
		try {
			Socket misocket = new Socket(host, puerto);
		
		// preparo el sitio donde escribir� en el socket
			OutputStream escrituraSocket = misocket.getOutputStream();
			OutputStreamWriter escritor = new OutputStreamWriter(escrituraSocket);
			BufferedWriter escribirAlServidor = new BufferedWriter(escritor);

			//Sobre la conexión establecida:
			System.out.println("Información: "
					+ "\npuerto local, por el que me conecto-->" + misocket.getLocalPort()
					+ "\npuerto al que me conecto-->" + misocket.getPort()
					+ "\nIp:" + misocket.getInetAddress().getHostAddress()
					);
		
		// envío algo al servidor
			escribirAlServidor.write("Hola Servidor!!");
			escribirAlServidor.newLine();
			escribirAlServidor.flush();
			
			// Escuchar al servidor
			InputStream lecturaSocket = misocket.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leerDelServidor = new BufferedReader(lector);
			// SOLO VOY A LEER UNA LÍNEA
			System.out.println("He leido del servidor=> " + leerDelServidor.readLine());
			
			
		// cerrar todos los streams y sockets
			leerDelServidor.close();
			escribirAlServidor.close();
			misocket.close();
			
			System.out.println("He terminado y soy el cliente");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConnectException e) {
			System.err.println("El servidor no está activo en el puerto " + puerto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}


}
