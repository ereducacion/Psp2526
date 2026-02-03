package socketsSeguros;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ClienteStreamSSL {
	
	public static void main(String[] args) {
		String host = "localhost";
		int puerto = 6000;
		
		// creamos el socket
		try {
			System.setProperty("javax.net.ssl.trustStore", "UsuarioAlmacenSSL");
			System.setProperty("javax.net.ssl.trustStorePassword", "890123");

			SSLSocketFactory fabricaSegura = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket socketSeguro = (SSLSocket) fabricaSegura.createSocket(host, puerto);
		
		// preparo el sitio donde escribir� en el socket
			OutputStream escrituraSocket = socketSeguro.getOutputStream();
			OutputStreamWriter escritor = new OutputStreamWriter(escrituraSocket);
			BufferedWriter escribirAlServidor = new BufferedWriter(escritor);
		
		// env�o algo al servidor
			escribirAlServidor.write("Hola Servidor!!");
			escribirAlServidor.newLine();
			escribirAlServidor.flush();
			
		// cerrar todos los streams y sockets
			escribirAlServidor.close();
			socketSeguro.close();
			
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
