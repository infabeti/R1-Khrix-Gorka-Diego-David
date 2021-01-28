package ModAD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.json.JSONObject;

public class DescargarIndex {
	
	public static void main(String[] args) throws IOException {
		String xml = convertirJSONXML.leerArchivo("./ficherosXML//index.xml", "utf-8"); 
		procesarDatosAtmosfericos(xml);
	}
	
	public static void procesarDatosAtmosfericos(String archivo) throws IOException {
		String nomMuni = "";
		String[] index, nodos, nombreMuni = null;

		index = archivo.split("</aggregated>");

		nombreMuni = new String[index.length - 1];
		//nombreMuniDef = new String[index.length -1];
		
		for (int i = 0; i < index.length; i++) {
			nodos = index[i].split("/");
			for (int j = 0; j < nodos.length; j++) {
				if (nodos[j].contains("<name>")) {
					for (int k = 0; k < nodos[j].length(); k++) {		
						if (nodos[j].charAt(k) == 'e') {
							nomMuni = nodos[j].substring(k, nodos[j].length() - 1);
							if (nomMuni.contains(">")) {
								nombreMuni[i] = nomMuni.substring(2);
								//System.out.println(nombreMuni[i]);
							}
						}
					}
				}
			}
		}		
		
		for(int i = 0; i < nombreMuni.length; i+=3) {
			DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/datos_indice/" + nombreMuni[i] + ".json", "./pruebaFich/" + nombreMuni[i] + ".json");
		}
		
		System.out.println("\nINICIADA CONVERSION A XML:\n");
	    String archivoJSON = "", archivoXML = "", archJson = "", archJsonSinCabecera = "", archJsonDefinitivo = "";
	    String contXML = "";
	    FileWriter ficheroXML = null;
    	for (int i = 0; i < nombreMuni.length; i+=3) {
    		archivoJSON = "./pruebaFich//" + nombreMuni[i] + ".json";
    		archivoXML = "./ficherosXML//" + nombreMuni[i] + ".xml";
    		
    		//INICIO DE LA PREPARACION DE NUESTRO JSON
    		archJson = convertirJSONXML.leerArchivo(archivoJSON, "Windows-1252"); // Lee el archivo
    		System.out.println("LEYENDO " + archivoJSON);
    		
    		//if(archJson.length()>0) {
    			archJsonSinCabecera = convertirJSONXML.repararJSONSinCabecera(archJson, nombreMuni[i]);
        		System.out.println("REPARANDO " + archivoJSON);
        		
        		//INICIO DE LA CONVERSION JSON-->XML
        		JSONObject objetoJson = new JSONObject(archJsonSinCabecera);
        		contXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><nodoRaiz>" + org.json.XML.toString(objetoJson) + "</nodoRaiz>";
        		
        		ficheroXML = new FileWriter(archivoXML);
    	    	try (BufferedWriter out = new BufferedWriter(ficheroXML)) {
    	    	    out.write(contXML);
    	    	}
    	    	ficheroXML.close();
    			//FIN CONVERSION JSON-->XML
        		System.out.println("Archivo " + nombreMuni[i]  + ".json convertido a " + nombreMuni[i] + ".xml correctamente");
    		//}
    		
    		
    	}
	}

}
