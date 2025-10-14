package metodos;

public class UsaHilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloSimple hs = new HiloSimple();
		hs.start();
		System.out.println("nombre=" + hs.getName());
		hs.setName("lala");
		System.out.println("nombre=" + hs.getName());
		System.out.println("id=" + hs.threadId());
		System.out.println("prioridad=" + hs.getPriority());
		hs.setPriority(hs.MIN_PRIORITY);
		System.out.println("prioridad=" + hs.getPriority());

		System.out.println("Estoy fuera del hilo... ");

	}

}
