package parseoJson;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseaJson {

	void parseaMonumentos(Reader elReader) {
		/*
		 * {
  "totalCount": 179,
  "start": 0,
  "rows": 2,
  "result": [
    {
      "id": 2,
      "title": "Museo del Foro de Caesaraugusta"
    },
    {
      "id": 94,
      "title": "Centro de Historias de Zaragoza. Antiguo Convento de San Agust�n"
    }
  ]
}
		 */
		try {
			Object obj = new JSONParser().parse(elReader);
			
			JSONObject jo = (JSONObject) obj;
			
			JSONArray ja = (JSONArray)jo.get("result"); 
			for (Iterator iterator = ja.iterator(); iterator.hasNext();) {
				JSONObject museo = (JSONObject) iterator.next();
				String nombre = (String)museo.get("title");
				System.out.println(nombre);
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
