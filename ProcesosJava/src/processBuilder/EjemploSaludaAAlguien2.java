package processBuilder;


import java.io.*;
import java.util.*;


public class EjemploSaludaAAlguien2 { 
	
	public static void main(String args[]) {
		
		ProcessBuilder probuilder = new ProcessBuilder();

		probuilder = probuilder.command("java", "-jar", "saludaAalguien.jar");
		try {
			
			 File fBat = new File("entrada.txt");
			 File fOut = new File("salida.txt");
			 File fErr = new File("error.txt");
			 
			probuilder.redirectInput(fBat);
			probuilder.redirectOutput(fOut);
			probuilder.redirectError(fErr); 
			       
			Process p= probuilder.start();
			
		}  
		catch (Exception e)  { e.printStackTrace(); }	
	}  
}//