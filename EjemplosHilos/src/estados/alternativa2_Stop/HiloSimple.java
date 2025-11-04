package estados.alternativa2_Stop;

public class HiloSimple  extends Thread {

	private boolean paraHilo;

	/**
	 * El constructor
	 */
	public HiloSimple() {
		paraHilo = false;
	}
	
	public void parar() {
		paraHilo = true;
	}
	
	public void run() {
		int numero = 0;
		while (!paraHilo) {
			System.out.println("soy " + this.getName() + " " + numero++);
		}
	}
}
