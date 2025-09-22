package processBuilder;


import java.io.*;
import java.util.*;


public class EjemploPB1 { 
	
	public static void main(String args[]) {
		
		ProcessBuilder test = new ProcessBuilder();
		Map entorno = test.environment();
		
		System.out.println("Variables de entorno:");
		System.out.println(entorno);   

		test = new ProcessBuilder("java", "SaludandoAAlguien", "\"Hola Mundo!!\"");

		//devuelve el nombre del proceso y sus argumentos	
		List l =test.command() ; 
		Iterator iter = l.iterator();
		System.out.println("Argumentos del comando:");  	
		while (iter.hasNext())
			System.out.println(iter.next());    

		//ejecutamos el comando DIR
		test = test.command("CMD","/C" ,"DIR");
		try {
			Process p= test.start();
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader (new InputStreamReader (is));                      
			String linea;
			while((linea = br.readLine())!=null) //lee la salida de Unsaludo 
				System.out.println(linea);
			br.close();
		}  
		catch (Exception e)  { e.printStackTrace(); }	
	}  
}//