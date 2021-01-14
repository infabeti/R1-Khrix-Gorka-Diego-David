package EuskWeather;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class convertirJSONXML {

	    public static void main(String[] args) {
	    	String[] nombreArchivos = { "index", "estaciones", "espacios-naturales", "municipios" };
		    String[] nomNodo = { "index", "estacion", "espacioNatural", "municipio" };
	    	for (int i = 0; i < nombreArchivos.length; i++) {
	    		String archivoJSON = "./archJSON//" + nombreArchivos[i] + ".json";
	    		String archivoXML = "./ficherosXML//" + nombreArchivos[i] + ".xml";
	    		
	    		// Lee el archivo JSON
	    		String jsonOrigen = leerArchivo(archivoJSON); // Lee el archivo

	    		String jsonPreparado = repararJSONSinCabecera(jsonOrigen, nomNodo[i]);

	    		String jsonCorregido = renombrarEtiquetasDuplicadas(jsonPreparado);
	    		
	    		// Convierte JSON a XML
	    		
	    		JSONObject objetoJson = new JSONObject(jsonCorregido);
	    		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><nodoRaiz>" + org.json.XML.toString(objetoJson) + "</nodoRaiz>";

	    		// Escribe el archivo XML
	    		FileWriter ficheroXML;
				try {
					ficheroXML = new FileWriter(archivoXML);
					BufferedWriter out = new BufferedWriter(ficheroXML);
		    		out.write(xml);
		    		
		    		ficheroXML.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    		
	    		System.out.println("Archivo " + nombreArchivos[i] + ".json convertido a " + nombreArchivos[i] + ".xml correctamente");
	    	}
	    }

	    public static String leerArchivo(String ruta) {
	    	StringBuilder acum = null;
	    	FileInputStream archJson;
			try {
				acum = new StringBuilder();
				archJson = new FileInputStream(ruta);
				Charset encoding = Charset.forName("UTF-8");
		    	InputStreamReader isr = new InputStreamReader(archJson, encoding);
		    	int cont = 0;
		    	while ((cont = isr.read()) != -1) {
		    		char ch = (char) cont;
		    		acum.append(ch);
		    	}	
		    	archJson.close();
		    	isr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	return acum.toString();
	    }

	    public static String repararJSONSinCabecera(String archJson, String nomNodo) {
	    	String contenidoSINCabecera = "", contenidoSINPiePagina = "", jsonReparado = "";
	    	boolean cabeceraEncontrada = false;
	    	String[] acumStrings;

	    	for (int i = 0; i <= archJson.length()-1; i++) {
	    		/*
	    		 * Encuentra el JSONCallback y con el booleano lo controla para borrarlo y salir del for
	    		 */
	    		if (archJson.charAt(i) == '{' && !cabeceraEncontrada) {
	    			contenidoSINCabecera = archJson.substring(i);
	    			cabeceraEncontrada = true;
	    		}
	    	}
		
	    	acumStrings = contenidoSINCabecera.split("}");
	    	contenidoSINPiePagina += acumStrings[0];
	    	
	    	for (int i = 1; i < acumStrings.length - 1; i++) {
	    		/*Ira cargando el String 'contenidoSINPiePagina' con el contenido del String
	    		 * con la cabecera quitada
	    		 */
	    		contenidoSINPiePagina += "\n}" + acumStrings[i];
	    	}

	    	if (archJson.charAt(0) == '{') {
	    		//FINALIZA LA ESTRUCTURA DEL NUEVO JSON TRATADO
	    		jsonReparado = contenidoSINPiePagina + "}\n]\n}";
	    	} else {
	    		/*
	    		 * En caso de no iniciar con una '{' le daremos una cabecera con
	    		 * el nombre del nodo de su futuro XML para una mejor identificacion
	    		 */
	    		jsonReparado = "{\n" + "\"" + nomNodo + "\"" + ": [ \n" + contenidoSINPiePagina + "\n}\n]\n}";
	    		/*
	    		 * TODOS LOS \n son necesarios ya que si no al intentar reparar los que tengan alguna
	    		 * etiqueta repetida dara error de formato y nos dira que hace falta un ',' o '{'
	    		 */
	    	}
	    	return jsonReparado;
	    }

	    public static String renombrarEtiquetasDuplicadas(String archJson) {
	    	String archivoCorregido = "";
	    	String archivoFinal = "";
	    	int contador1 = 0;
	    	int contador2 = 0;
	    	int contador3 = 0;
	    	String[] acumString;
	    	String[] nodosJson;
	    	acumString = archJson.split("}");
	    	for (int i = 0; i < acumString.length; i++) {
	    		nodosJson = acumString[i].split(" : ");
	    		for (int j = 0; j < nodosJson.length; j++) {
	    			if (nodosJson[j].toString().contains("\"turismDescription\"") && contador1 > 0) {
	    				archivoCorregido += "\"turismDescription" + contador1 + "\"" + " : ";
	    				contador1++;
	    			/*} else if (nodosJson[j].toString().contains("\"address\"") && contador2 > 0) {
	    				archivoCorregido += nodosJson[j].substring(0, nodosJson[j].length() - 9) + "\"address" + contador2 + "\"" + " : ";
	    				contador2++;
	    			} else if (nodosJson[j].toString().contains("\"phone\"") && contador3 > 0) {
	    				archivoCorregido += nodosJson[j].substring(0, nodosJson[j].length() - 7) + "\"phone" + contador3 + "\"" + " : ";
	    				contador3++;*/
	    			} else if (nodosJson[j].toString().contains("\"turismDescription\"") && contador1 == 0) {
	    				archivoCorregido += nodosJson[j] + " : " + nodosJson[j + 1].substring(0, nodosJson[j + 1].length() - 19);
	    				contador1++;
	    			/*} else if (nodosJson[j].toString().contains("\"address\"") && contador2 == 0) {
	    				archivoCorregido += nodosJson[j] + " : ";
	    				contador2++;
	    			} else if (nodosJson[j].toString().contains("\"phone\"") && contador3 == 0) {
	    				archivoCorregido += nodosJson[j] + " : ";
	    				contador3++;*/
	    			} else {
	    				archivoCorregido += nodosJson[j];
	    				if (nodosJson[j].charAt(nodosJson[j].length() - 1) != (char) 10) {
	    					archivoCorregido += " : ";
	    				}
	    			}
	    		}
	    		archivoCorregido = archivoCorregido.substring(0, archivoCorregido.length() - 2);

	    		nodosJson = null;
	    		contador1 = 0;
	    		contador2 = 0;
	    		contador3 = 0;
	    		archivoCorregido += "}";
	    	}
	    	archivoCorregido = archivoCorregido.substring(0, archivoCorregido.length() - 1);
	    	archivoCorregido += "]\n}";
	    	// Eliminar etiquetas vacias
	    	nodosJson = archivoCorregido.split(",");
	    	for (int i = 0; i < nodosJson.length; i++) {
	    		if (!nodosJson[i].toString().contains("\"\"")) {
	    			archivoFinal += nodosJson[i] + ",";
	    		}
	    	}
	    	archivoFinal = archivoFinal.substring(0, archivoFinal.length() - 1); // Le quita la última ","

	    	return archivoFinal;
	    }

}
