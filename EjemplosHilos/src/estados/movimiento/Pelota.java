package estados.movimiento;

import java.awt.*;

class Pelota extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int PosX = 20, PosY = 50; // Posici�n de la pelota

	int DirX = PosX % 10 + 1; // Direcci�n de la pelota
	int DirY = PosY % 10 + 1; // Direcci�n de la pelota
	int radioPelota = 10; // Radio de la pelota


	public Pelota() {
		this.setSize(300, 300);
		this.setVisible(true);
	}

	public void mover()
	    {
	        PosX+=DirX; 
	        PosY+=DirY;
	        if ((PosX-radioPelota) <= 0)
	        DirX*= -1;
	        else if ((PosX+radioPelota) >= getWidth())
	            DirX*= -1;
	 
	        if ((PosY-radioPelota) <= 0)
	            DirY*= -1;
	            else if ((PosY+radioPelota) >= getHeight())
	            DirY*= -1;
	    }

	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(PosX - radioPelota, PosY - radioPelota, radioPelota * 2, radioPelota * 2);
	}
	
	public void cerrar() {
		this.dispose();
	}
	


}