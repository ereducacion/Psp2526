package socketsBidireccional;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * 
 * ESTA CLASE ES UNA PRUEBA BIDIRECCIONAL
 * ES EL SERVIDOR
 * 
 * PRIMERO VA A LEER Y DESPUÉS VA A ESCRIBIR
 */
public class ServidorStream {

	public static void main(String[] args) {
		int puerto = 6000;
		
		try {
			ServerSocket miServidor = new ServerSocket(puerto);
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidor.setSoTimeout(100000);
			Socket cliente = miServidor.accept();
			System.out.println("se ha conectado, esperando entrada Cliente");
			
			//Sobre la conexión establecida:
			System.out.println("Información CLIENTE: "
					+ "\npuerto local, por el que me conecto-->" + cliente.getLocalPort()
					+ "\npuerto al que me conecto-->" + cliente.getPort()
					+ "\nIp:" + cliente.getInetAddress().getHostAddress()
					);

			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = cliente.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leeCliente = new BufferedReader(lector);
			
			String linea = leeCliente.readLine();
			System.out.println("He leido =>" + linea);
			 
			// Escribir algo al cliente
			OutputStream escrituraSocket = cliente.getOutputStream();
			OutputStreamWriter escritor = new OutputStreamWriter(escrituraSocket);
			BufferedWriter escribirAlCliente = new BufferedWriter(escritor);
			
			escribirAlCliente.write("Me has dicho: " + linea + " GRACIAS");
			escribirAlCliente.newLine();
			escribirAlCliente.flush();
			
			
			// cierro todos los recursos
			leeCliente.close();
			miServidor.close();
			
		} catch (SocketTimeoutException e) {
			System.err.println("Se ha cerrado la conexión por tiempo");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
