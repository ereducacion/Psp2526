package parseoJson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import utilidades.Utilidades;

public class ConsultaMonumentos {


	private static final String _PROTOCOLO  = "https";
	private static final String _HOST  = "www.zaragoza.es";
	private static final String _PATH  = "/sede/servicio/monumento.json";
	// QUERY  = "srsname=wgs84&rows=2&fl=id,title";
	private static final String _QUERY1  = "srsname=wgs84&rows=";
	private static final String _QUERY2  = "&fl=id,title";


	public static void main(String[] args) throws Exception {

		int numFilas = Utilidades.preguntaPorEntero("¿Cuántos monumentos quieres consultar?");
		URL url = new URL(_PROTOCOLO, _HOST, _PATH + "?" + _QUERY1 + numFilas + _QUERY2);

		// vamos a establecer una conexión HTTP con un mínimo control de errores
		HttpURLConnection con = (HttpURLConnection) url.openConnection();

		// decimos que va a ser una conexión tipo GET y esperamos un json
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setConnectTimeout(10000);
		con.setReadTimeout(10000);

		// Comprobar que la respuesta es un OK, que ha ido todo bien
		int status = con.getResponseCode();
		if (status != HttpURLConnection.HTTP_OK) {
			System.err.println("Se ha producido un error al conectar por HTTP");
			System.exit(1);
		}

//		InputStreamReader lectorstream = new InputStreamReader(con.getInputStream());
//		BufferedReader bufferlector = new BufferedReader(lectorstream);
//		String linea;
//		while ((linea = bufferlector.readLine()) != null) {
//			System.out.println(linea);
//		}
//		bufferlector.close(); // IMPORTANTE PARA LIBERAR RECURSOS 

		ParseaJson parseador = new ParseaJson();
		parseador.parseaMonumentos(new InputStreamReader(con.getInputStream()));

	}

}