package chat.servidor;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

import interfaz.VentanaServidor;
import util.CapturePanel;
import util.Consumer;
import util.ProxyPrintStream;
import util.StreamCapturer;

public class Servidor {

	private static final String PROPERTIES_FILE = "src/config/datos.properties";
	
	/**
	 * Muestra en pantalla un panel con un área de texto que mostrará la salida indicada (out o err)
	 * @param textAreaServidor
	 */
	public static void cargaPanel(Consumer textAreaServidor) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaServidor window = new VentanaServidor();
					window.agnadePanel(textAreaServidor);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	public static void main(String[] args) {	
		Properties properties = new Properties();
		Consumer textAreaServidor = new CapturePanel(); // area de texto que meteremos en una ventana

		try {
			
		    properties.load(new BufferedReader(new FileReader(PROPERTIES_FILE)));
		    int puerto = Integer.valueOf(properties.getProperty("puertoEscucha"));

		    // preparo el panel de salida de mensajes---------
			System.setOut(new PrintStream(new StreamCapturer("STDOUT", textAreaServidor, System.out)));
			cargaPanel(textAreaServidor);
			
			// guardaré la salida de error en un fichero de log
			System.setErr(new ProxyPrintStream(System.err, "stderr.log"));
			//------------------------------------------------
		    
			ServerSocket miServidor = new ServerSocket(puerto);
			System.out.println("SERVIDOR: Escuchando por el puerto " + puerto);
			miServidor.setSoTimeout(0);
			//ArrayList<MiHilo> listaHilos = new ArrayList<MiHilo>();
			
			for (int i = 1; i <= 4; i++) {
				Socket cliente = miServidor.accept();
				System.out.println("Conectado cliente " + i);
				
				MiHilo h = new MiHilo(i, cliente);
				h.start();
				//listaHilos.add(h);
			}

			// espero a que terminen los hilos para cerrar???
			miServidor.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// cierro la ventana!!!
		//frame.dispose();
	}
	
}
