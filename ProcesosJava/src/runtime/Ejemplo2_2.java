package runtime;
import java.io.*;
public class Ejemplo2_2 {    
   	public static void main(String[] args)  {
	  Runtime r = Runtime.getRuntime();    
	  String[] comando= {"CMD", "/C", "patata"} ;
	  Process p=null;
      try {
  		  p = r.exec( comando );
          InputStream StreamEntrada = p.getInputStream();
          BufferedReader br = new BufferedReader (new InputStreamReader (StreamEntrada));                      
          String linea;
		  while((linea = br.readLine())!=null) { //lee una l�nea del fichero 
              System.out.println(linea); 
		  }
		  br.close();
        } 
        catch (Exception e) {
              e.printStackTrace();
        }
		
		// CONTROL DE LOS MENSAJES DE ERROR
		try {
			InputStream StreamError = p.getErrorStream();					
			BufferedReader brer = new BufferedReader(new InputStreamReader(StreamError));
			String liner = null;
			while ((liner = brer.readLine()) != null) {
				System.err.println("ERROR >" + liner);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		// COMPROBACION DE ERROR:  0 indica que ha terminado bien
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
    }
}//Ejemplo2