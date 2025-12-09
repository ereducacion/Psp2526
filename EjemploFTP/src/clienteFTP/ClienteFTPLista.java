package clienteFTP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class ClienteFTPLista {

	public static void main(String[] args) {

		// Creando nuestro objeto ClienteFTP

		// Datos para conectar al servidor FTP
		String ftp = "localhost"; // También puede ir la IP
		String user = "usuario1";
		String password = "usuario1";

		try {
			FTPClient client = new FTPClient();

			// Conectarse al servidor
			client.connect(ftp);

			// Loguearse con un usuario 
			// (true = pudo conectarse, false = no pudo conectarse)
			boolean login = client.login(user, password);

			if (login) { 
				System.out.println("Me he logeado");

				client.enterLocalPassiveMode();

				// intento listar los ficheros
				FTPFile[] files = client.listFiles();   // paginamos de 25 en 25
				if (FTPReply.isPositiveCompletion(client.getReplyCode())) {
					for (int i = 0; i < files.length; i++) {
						FTPFile fichero = files[i];
						System.out.println(fichero.getName());
					}
				} else {
					System.err.println("Algo ha fallado");
					System.err.println(client.getReplyString());
				}

				System.out.println("Voy a salir");
				// Cerrando sesión
				client.logout();
			} else {
				System.out.println("No me logeo");
			}

			// Desconectandose con el servidor
			client.disconnect();

		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println(ioe.getMessage());
		}
	}
}
