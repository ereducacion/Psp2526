package runtime;
import java.io.*;

public class Ejemplo1_2 {    

	public static void main(String[] args)  {
		Runtime r = Runtime.getRuntime();    
		String[] comando= {"Notepad"};
		Process p=null;
		try {
			p = r.exec( comando );         
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		// COMPROBACION DE ERROR:  0 indica que ha terminado bien
		int exitVal;
		try {
			System.out.println("antes del wait");
			if (p !=null) {
				exitVal = p.waitFor();
				System.out.println("Valor de Salida: " + exitVal);
			}
			System.out.println("despues del wait");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}
}//Ejemplo2