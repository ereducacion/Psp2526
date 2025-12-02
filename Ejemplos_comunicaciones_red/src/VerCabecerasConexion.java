import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * Para escribir en un servicio web, utilizando la clase URLConnection
 * 
 * @author Eva
 *
 */
public class VerCabecerasConexion {
	public static void main(String[] args) {
		VerCabecerasConexion inicio = new VerCabecerasConexion();
		inicio.haz();
	}// main

	private void haz() {
		try {
			// 1 - DONDE ME QUIERO CONECTAR
						URL url = new URL("http://192.168.23.3/psp/vernombre.php");
						
						// 2 - ME CONECTO
						URLConnection conexion = url.openConnection();
						
						// 3 - QUE VOY A PASARLE
						String cadena ="nombre=Maria Jesus&apellido=Ramos Martin";
						
						// 4- ESCRIBO LO QUE VOY A PASARLE
						// 4.1- me aseguro de que voy a poder escribir en la conexión que tengo (por defecto es true)
						conexion.setDoOutput(true);
						OutputStream salidaStream = conexion.getOutputStream();
						PrintWriter salida = new PrintWriter(salidaStream);
						salida.write(cadena);
						salida.flush();	 
						salida.close(); // IMPORTANTE PARA LIBERAR RECURSOS 
						
						// 5- LEO LO QUE ME HA RESPONDIDO
						InputStreamReader lectorstream = new InputStreamReader(conexion.getInputStream());
						BufferedReader bufferlector = new BufferedReader(lectorstream);
						String linea;
						while ((linea = bufferlector.readLine()) != null) {
							System.out.println(linea);
						}
						bufferlector.close(); // IMPORTANTE PARA LIBERAR RECURSOS 

			System.out.println("=================================================== ");
			System.out.println("Direccion [getURL()]:" + conexion.getURL());

			Date fecha = new Date(conexion.getLastModified());
			System.out.println("Fecha ultima modificacion [getLastModified()]: " + fecha);
			System.out.println("Tipo de Contenido [getContentType()]: "	+ conexion.getContentType());

			System.out.println("=================================================== ");
			System.out.println("TODOS LOS CAMPOS DE CABECERA CON getHeaderFields(): ");
			
			
			Map camposcabecera = conexion.getHeaderFields();
			Iterator it = camposcabecera.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry map = (Map.Entry) it.next();
				System.out.println(map.getKey() + " : " + map.getValue());
			}
			System.out.println("=================================================== ");
			System.out.println("CAMPOS 1 Y 4 DE CABECERA:");
			System.out.println("getHeaderField(1)=> " + conexion.getHeaderField(1));
			System.out.println("getHeaderField(4)=> " + conexion.getHeaderField(4));
			System.out.println("=================================================== ");

			// para ver lo que me responde el servidor cuando no le pongo nada como 
			// escritura en la URL
			System.out.println("CONTENIDO DE [url.getFile()]:" + url.getFile());
			BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));

			while ((cadena = pagina.readLine()) != null) {
					System.out.println(cadena);
			}		
			
			
		} catch (MalformedURLException me) {
			System.err.println("MalformedURLException: " + me);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}

	}

	
}
