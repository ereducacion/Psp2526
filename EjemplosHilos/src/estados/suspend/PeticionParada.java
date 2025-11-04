package estados.suspend;

public class PeticionParada {

	private boolean suspendRequested;
	
	/**
	 * Es synchronized por si se crea más de un hilo que use este clase
	 * Para o activa el hilo
	 * 
	 * @param b
	 */
	public synchronized void accion(boolean b) {
		suspendRequested = b;
		notifyAll(); // si se ejecuta aunque no esté bloqueado, no pasa nada.
	}
	
	/**
	 * Es synchronized por si se crea m�s de un hilo que use este clase
	 * Paraliza al objeto que lo usa, y mientras el valor de la variable
	 * sea true, se paralizar�
	 * @throws InterruptedException
	 */
	public synchronized void esperarResume() throws InterruptedException {
		
		while (suspendRequested)
			wait(); // se queda esperando
	}
}
