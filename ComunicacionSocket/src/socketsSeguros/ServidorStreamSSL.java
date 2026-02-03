package socketsSeguros;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;


public class ServidorStreamSSL {

	public static void main(String[] args) {
		int puerto = 6000;
		
		try {
			System.setProperty("javax.net.ssl.keyStore", "AlmacenSSL2");
			System.setProperty("javax.net.ssl.keyStorePassword", "1234567");
		
			SSLServerSocketFactory fabricaSegura = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			SSLServerSocket miServidorSeguro = (SSLServerSocket) fabricaSegura.createServerSocket(puerto);
			
						
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidorSeguro.setSoTimeout(0);
			SSLSocket cliente = (SSLSocket) miServidorSeguro.accept();
			System.out.println("se ha conectado, esperando entrada Cliente");
			
			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = cliente.getInputStream();
			InputStreamReader lector = new InputStreamReader(lecturaSocket);
			BufferedReader leeCliente = new BufferedReader(lector);
			
			String linea = leeCliente.readLine();
			System.out.println("He leido =>" + linea);
			 
			// cierro todos los recursos
			leeCliente.close();
			miServidorSeguro.close();
			
		} catch (SocketTimeoutException e) {
			System.err.println("Se ha cerrado la conexión por tiempo");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
