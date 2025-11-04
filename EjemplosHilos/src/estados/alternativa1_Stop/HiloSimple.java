package estados.alternativa1_Stop;

public class HiloSimple extends Thread {

	private Thread yomismo;
	
	/**
	 * El constructor
	 */
	public HiloSimple() {
		yomismo = this;
	}
	
	public void parar() {
		yomismo = null;
	}
	
	public void run() {
		int i=0;
		while 
			(Thread.currentThread() == yomismo) {
			System.out.println("hilo, iteración " + i);
			i++;
		}
	}
}
