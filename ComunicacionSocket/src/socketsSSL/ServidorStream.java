package socketsSSL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;


public class ServidorStream {

	public static void main(String[] args) {
		int puerto = 6000;
		
		try {
			System.setProperty("javax.net.ssl.keyStore", "src\\socketsSSL\\AlmacenSSLEva");
			System.setProperty("javax.net.ssl.keyStorePassword", "1234567");
			
			SSLServerSocketFactory miFabricaSegura = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			SSLServerSocket miServidorSSL = (SSLServerSocket) miFabricaSegura.createServerSocket(puerto);
			
			System.out.println("Dirección desde la que se conecta el servidor:"
			+ miServidorSSL.getInetAddress().getHostAddress());
			
			//ServerSocket miServidor = new ServerSocket(puerto);
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidorSSL.setSoTimeout(0);
			SSLSocket cliente = (SSLSocket) miServidorSSL.accept(); // BLOQUEA EL CÓDIGO
			System.out.println("se ha conectado, esperando entrada Cliente");
			
			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = cliente.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leeCliente = new BufferedReader(lector);
			
			String linea = leeCliente.readLine();
			System.out.println("He leido =>" + linea);
			 
			// cierro todos los recursos
			leeCliente.close();
			miServidorSSL.close();
			
		} catch (SocketTimeoutException e) {
			System.err.println("Se ha cerrado la conexión por tiempo");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
