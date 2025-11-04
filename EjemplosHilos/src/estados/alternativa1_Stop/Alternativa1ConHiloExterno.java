package estados.alternativa1_Stop;

import java.util.Scanner;

public class Alternativa1ConHiloExterno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HiloSimple hs = new HiloSimple();
		hs.start();

		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		hs.parar();
		System.err.println("Parado");
		
	}

}
