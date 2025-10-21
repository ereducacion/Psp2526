package runtime;
/**
 * Lanza un proceso en Java, concretamente abre el programa Notepad
 * @author Eva Royo
 *
 */
public class Ejemplo1_1 {
	public static void main(String[] args)  {
     Runtime r = Runtime.getRuntime();
 	String[] comando= {"Notepad"};
	 
	 Process p;
	 try {
		p = r.exec( comando );
		p.waitFor();
		System.err.println("Terminé!!");
	 } catch (Exception e) {	 
	     System.out.println("Error en: "+comando );
	     e.printStackTrace();
	 }
	}
}//Ejemplo1
