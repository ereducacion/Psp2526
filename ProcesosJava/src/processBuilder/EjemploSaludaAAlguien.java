package processBuilder;


import java.io.*;
import java.util.*;


public class EjemploSaludaAAlguien { 
	
	public static void main(String args[]) {
		
		ProcessBuilder probuilder = new ProcessBuilder();

		probuilder = probuilder.command("java", "-jar", "saludaAalguien.jar");
		try {
			Process p= probuilder.start();
			// inyectarle la entrada al proceso
			OutputStream os = p.getOutputStream();
			BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(os));
			bw.write("Fulanitooo");			
			
			bw.close();
			
			// recogo lo que produce como salida
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