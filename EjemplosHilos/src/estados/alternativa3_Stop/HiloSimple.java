package estados.alternativa3_Stop;

public class HiloSimple  extends Thread {

	/**
	 * El constructor
	 */
	public HiloSimple() {
	}
	
	public void run() {
		int numero = 0;
		while (!isInterrupted()) {
			System.out.println("soy " + this.getName() + " " + numero++);
		}
	}
}
