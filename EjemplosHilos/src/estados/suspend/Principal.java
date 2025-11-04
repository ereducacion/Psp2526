package estados.suspend;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		MiHilo hilopropio = new MiHilo("Soy un hilo");

		System.out.println("Introduce:\n * para parar*\n - para detener el hilo\n + para activar el hilo");
		
		hilopropio.start();
		
		boolean salir = false;
		String linea;
		Scanner teclado = new Scanner(System.in);
		while (!salir) {
			linea = teclado.nextLine();
			if (linea.equals("*")) salir = true;
			if (linea.equals("-")) hilopropio.requestSuspend();
			if (linea.equals("+")) hilopropio.requestResume();
		}
		
		// de momento uso esto aunque no hay que usarlo
		hilopropio.stop();
		System.out.println("Termino");		
	}
}
