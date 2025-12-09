package clienteFTP;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class ClienteFTPSubirFichero {

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
				client.setFileType(FTP.BINARY_FILE_TYPE, FTP.BINARY_FILE_TYPE);
				client.setFileTransferMode(FTP.BINARY_FILE_TYPE);
				client.enterLocalPassiveMode();

				String filename = "algo.txt";

				FileInputStream fis = new FileInputStream(filename);

				// Guardando el archivo en el servidor
				boolean resultado = client.storeFile(filename, fis);
				if (!resultado) {
					System.out.println("ERROR al cargar el fichero en el sevidor, no he podido");
				}

				// Cerrando sesión
				client.logout();
			}

			System.out.println("Voy a salir");
			// Desconectandose con el servidor
			client.disconnect();

		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
