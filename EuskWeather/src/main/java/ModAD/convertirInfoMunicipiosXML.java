package ModAD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class convertirInfoMunicipiosXML {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    String archivoJSON = "", archivoXML = "", archJson = "", archJsonSinCabecera = "", archJsonDefinitivo = "";
	    String contXML = "";
	    FileWriter ficheroXML = null;
	    int i = 1;
    		archivoJSON = "./ficheros//" + Integer.toString(i) + ".json";
    		archivoXML = "./ficherosXML//" + Integer.toString(i) + ".xml";
    		
    		//INICIO DE LA PREPARACION DE NUESTRO JSON
    		archJson = convertirJSONXML.leerArchivo(archivoJSON, "Windows-1252"); // Lee el archivo
    		archJsonSinCabecera = convertirJSONXML.repararJSONSinCabecera(archJson, "datosMunicipio");
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
    		System.out.println("Archivo 0.json convertido a 0.xml correctamente");
	}

}
