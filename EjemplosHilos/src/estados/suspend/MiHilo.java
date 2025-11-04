package estados.suspend;

public class MiHilo extends Thread {
	
	private PeticionParada suspender = new PeticionParada();
	private String frase;

	public MiHilo (String frase) {
		this.frase = frase;
	}
	public void requestSuspend() {
		suspender.accion(true);
	}

	public void requestResume() {
		suspender.accion(false);
	}

	public void run()  {
	    try  {
	    	while (true) {
	    		 //realizar el trabajo
	    		System.out.println(frase + "-----" + threadId());
	    		sleep(1000);
	    		suspender.esperarResume();
	    	}
	    }catch (InterruptedException exception) { 
	    	System.err.println("Se ha producido una interrupción " + exception.getMessage());
	    }
	 }
}
