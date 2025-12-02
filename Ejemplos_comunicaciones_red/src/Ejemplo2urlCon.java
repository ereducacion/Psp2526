import java.io.*;
import java.net.*;

public class Ejemplo2urlCon {
  public static void main(String[] args) {
   try { 
    URL url = new URL("http://192.168.23.3/psp/vernombre.php");
    URLConnection conexion = url.openConnection();
    conexion.setDoOutput(true);           
        
    String cadena ="nombre=Mariana&apellido=Ozores";
           
    //ESCRIBIR EN LA URL
    PrintWriter output = new PrintWriter 
                        (conexion.getOutputStream());
    output.write(cadena);
	output.flush();	 
	output.close();
	
      //LEER DE LA URL
	BufferedReader reader = new BufferedReader
              (new InputStreamReader(conexion.getInputStream()));
	String linea;
	while ((linea = reader.readLine()) != null) {
			  System.out.println(linea);
	}			
	reader.close();
			
    } catch (MalformedURLException me) {
            System.err.println("MalformedURLException: " + me);
    } catch (IOException ioe) {
            System.err.println("IOException: " + ioe);
   }
  }//main
}//Ejemplo2urlCon 
