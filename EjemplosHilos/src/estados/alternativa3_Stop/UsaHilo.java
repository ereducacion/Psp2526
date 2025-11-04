package estados.alternativa3_Stop;

import java.util.Scanner;

public class UsaHilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HiloSimple hilo = new HiloSimple();
		hilo.start();
	
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		hilo.interrupt();
		
		System.out.println("Termino y soy main");

	}

}
