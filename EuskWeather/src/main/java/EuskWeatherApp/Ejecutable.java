package EuskWeatherApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import ModAD.DescargarPrincipales;
import ModAD.convertirJSONXML;

public class Ejecutable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//DESCARGAR FICHEROS PRINCIPALES
		System.out.println("INICIANDO DESCARGA DE FICHEROS:\n");
		DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/index.json", "./archJSON//index.json");
		DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/estaciones.json", "./archJSON//estaciones.json");
		DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/playas_de_euskadi/opendata/espacios-naturales.json", "./archJSON//espacios-naturales.json");
		DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_registros/registro_entidades_locales/opendata/entidades.json", "./archJSON//municipios.json");
	
		//CONVERTIRLOS A XML
		System.out.println("\nINICIADA CONVERSION A XML:\n");
		String[] nombreArchivos = { "index", "estaciones", "espacios-naturales", "municipios" };
	    String[] nomNodo = { "index", "estacion", "espacioNatural", "municipio" };
	    String archivoJSON = "", archivoXML = "", archJson = "", archJsonSinCabecera = "", archJsonDefinitivo = "";
	    String contXML = "";
	    FileWriter ficheroXML = null;
    	for (int i = 0; i < nombreArchivos.length; i++) {
    		archivoJSON = "./archJSON//" + nombreArchivos[i] + ".json";
    		archivoXML = "./ficherosXML//" + nombreArchivos[i] + ".xml";
    		
    		//INICIO DE LA PREPARACION DE NUESTRO JSON
    		archJson = convertirJSONXML.leerArchivo(archivoJSON, "Windows-1252"); // Lee el archivo
    		archJsonSinCabecera = convertirJSONXML.repararJSONSinCabecera(archJson, nomNodo[i]);
    		archJsonDefinitivo = convertirJSONXML.distinguirEtiquetasRepes(archJsonSinCabecera);
    		//AQUI YA TENDREMOS NUESTRO JSON PERTINENTE PREPARADO
    		
    		//INICIO DE LA CONVERSION JSON-->XML
    		JSONObject objetoJson = new JSONObject(archJsonDefinitivo);
    		contXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><nodoRaiz>" + org.json.XML.toString(objetoJson) + "</nodoRaiz>";

    		ficheroXML = new FileWriter(archivoXML);
	    	try (BufferedWriter out = new BufferedWriter(ficheroXML)) {
	    	    out.write(contXML);
	    	}
	    	ficheroXML.close();
			//FIN CONVERSION JSON-->XML
    		System.out.println("Archivo " + nombreArchivos[i] + ".json convertido a " + nombreArchivos[i] + ".xml correctamente");
    	}
    	
    	//VOLCAR INFORMACION A LA BD CON HIBERNATE
    	
	}

}
