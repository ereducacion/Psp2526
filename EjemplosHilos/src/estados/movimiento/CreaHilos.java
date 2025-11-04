package estados.movimiento;

import java.util.Scanner;

public class CreaHilos {

	public static void main(String[] args) {
		
		HiloPelota hilo = new HiloPelota();


		System.out.println("Introduce:\n * para parar TODO\n 1 para detener el hilo1\n 11voler a mover");
		

		hilo.start();
		
		boolean salir = false;
		String linea;
		try (Scanner teclado = new Scanner(System.in)) {
			while (!salir) {
				linea = teclado.nextLine();
				if (linea.equals("*")) salir = true;
				if (linea.equals("1")) hilo.requestSuspend();
				if (linea.equals("11")) hilo.requestResume();
			}
		}
		// parar el hilo
		hilo.paraHilo();
		
		System.out.println("Termino");	
		
	}
}
