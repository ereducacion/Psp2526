package socketsBidireccional;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 
 * ESTA CLASE ES UNA PRUEBA BIDIRECCIONAL
 * ES EL SERVIDOR
 * 
 * PRIMERO VA A LEER Y DESPUÉS VA A ESCRIBIR
 */
public class ServidorDataInput {

	public static void main(String[] args) {
		int puerto = 6000;
		
		try {
			ServerSocket miServidor = new ServerSocket(puerto);
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidor.setSoTimeout(0);
			Socket cliente = miServidor.accept();
			System.out.println("se ha conectado, esperando entrada Cliente");
			
			// Para leer lo que llegue por el nuevo socket
			InputStream lecturaSocket = cliente.getInputStream();
			DataInputStream leeCliente = new DataInputStream(lecturaSocket);
			
			String linea = leeCliente.readUTF();
			System.out.println("He leido =>" + linea);
			 
			// preparo el sitio donde escribiré en el socket
			OutputStream escrituraSocket = cliente.getOutputStream();
			DataOutputStream escribirAlCliente = new DataOutputStream(escrituraSocket);
		
			// envío algo al servidor
			escribirAlCliente.writeUTF("Hola Cliente!! soy el Servidor");
			escribirAlCliente.flush();

			// cierro todos los recursos
			escribirAlCliente.close();
			leeCliente.close();
			miServidor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
