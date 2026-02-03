package socketsSSL;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class ClienteStream {
	
	public static void main(String[] args) {
		String host = "0.0.0.0";
		int puerto = 6000;
		
		// creamos el socket
		try {
			System.setProperty("javax.net.ssl.trustStore", "src\\socketsSSL\\UsuarioAlmacenSSLEva");
			System.setProperty("javax.net.ssl.trustStorePassword", "890123");
			
			SSLSocketFactory fabricaSeguraCliente = (SSLSocketFactory) SSLSocketFactory.getDefault();
			SSLSocket misocket = (SSLSocket) fabricaSeguraCliente.createSocket(host, puerto);
		
		// preparo el sitio donde escribir� en el socket
			OutputStream escrituraSocket = misocket.getOutputStream();
			OutputStreamWriter escritor = new OutputStreamWriter(escrituraSocket);
			BufferedWriter escribirAlServidor = new BufferedWriter(escritor);
		
			
		// env�o algo al servidor
			escribirAlServidor.write("Hola Servidor!!");
			escribirAlServidor.newLine();
			escribirAlServidor.flush();
			
			System.out.println("He terminado y soy el cliente");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// cerrar todos los streams y sockets
			escribirAlServidor.close();
			misocket.close();
			
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
