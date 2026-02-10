package chat.cliente;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import interfaz.VentanaCliente;
import interfaz.VentanaServidor;
import util.CapturePanel;
import util.Consumer;
import util.ProxyPrintStream;
import util.StreamCapturer;

public class Cliente {
	private static final String PROPERTIES_FILE = "src/config/datos.properties";

	public static void cargaPanel(Consumer textAreaServidor) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente window = new VentanaCliente();
					window.agnadePanel(textAreaServidor);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void main(String[] args) throws InterruptedException {

		Properties properties = new Properties();
		Consumer textAreaCHAT = new CapturePanel(); // area de texto que meteremos en una ventana
	

		
		try {
			
			System.out.println("TERMINO");

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
