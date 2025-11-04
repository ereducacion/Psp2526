package estados.movimiento;

import estados.suspend.PeticionParada;

public class HiloPelota extends Thread {
	
	private PeticionParada suspender = new PeticionParada();
	private Pelota p = null;
	private long velocidad = 10;
	private boolean pararhilo = false;

	public HiloPelota () {
		this.velocidad = 10;
		p = new Pelota();
	}
	public void requestSuspend() {
		suspender.accion(true);
	}

	public void requestResume() {
		suspender.accion(false);
	}

	public void paraHilo () {
		pararhilo = true;
	}
	
	public void run()  {
	    try  {
	    	while (!pararhilo) {
	    		 //realizar el trabajo
	    		p.mover();
	    		p.repaint();
	    		try {
					Thread.sleep(velocidad);
				} catch (InterruptedException exc) {
				}
	    		// me pregunto si tengo que suspenderme
	    		suspender.esperarResume();
	    	}
	    	if (pararhilo) p.cerrar();
	    }catch (InterruptedException exception) { 
	    	System.err.println("Se ha producido una interrupci�n " + exception.getMessage());
	    } catch (NullPointerException e) {
			System.out.println("se ha parado el hilo");
		}
	 }
}
