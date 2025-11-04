package estados.alternativa1_Stop;

import java.util.Scanner;

public class Alternativa1 {

	private static Thread hilo = null;

	public static void main(String[] args) {

		hilo = new Thread() {
			public void run() {
				Thread yomismo = Thread.currentThread();
				while(hilo == yomismo) {
					System.out.println("Estoy en el hilo...duermo medio segundo, enter para parar");
					try {
						sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		// programa principal
		
		hilo.start();

		Scanner teclado = new Scanner(System.in);
		teclado.nextLine();

		hilo = null;

	}

}
