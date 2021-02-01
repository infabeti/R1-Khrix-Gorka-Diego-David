package EuskWeatherApp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import org.json.JSONObject;

import ModAD.DescargarIndex;
import ModAD.DescargarPrincipales;
import ModAD.EspacioNatural;
import ModAD.EstacionMeteorologica;
import ModAD.Hashes;
import ModAD.InformacionMeteorologica;
import ModAD.Municipios;
import ModAD.VolcarEspaciosNaturales;
import ModAD.VolcarEstaciones;
import ModAD.VolcarHashes;
import ModAD.VolcarInfoMeteorologica;
import ModAD.VolcarMunicipios;
import ModAD.convertirJSONXML;

public class Ejecutable {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//DESCARGAR FICHEROS PRINCIPALES
		System.out.println("INICIANDO DESCARGA DE FICHEROS:\n");
		//DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/index.json", "./archJSON//index.json");
		//DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/estaciones.json", "./archJSON//estaciones.json");
		//DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/playas_de_euskadi/opendata/espacios-naturales.json", "./archJSON//espacios-naturales.json");
		//DescargarPrincipales.descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_registros/registro_entidades_locales/opendata/entidades.json", "./archJSON//municipios.json");
	
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
    	
    	//INFORMACION METEOROLOGICA
    	String infoMeteo = convertirJSONXML.leerArchivo("./ficherosXML//index.xml", "utf-8");
    	DescargarIndex.procesarDatosAtmosfericos(infoMeteo);
	    
//	    String archivoIndex = convertirJSONXML.leerArchivo("./ficherosXML//index.xml", "utf-8");
//	    String[] nombresMunis = VolcarInfoMeteorologica.obtenerNombreMunicipios(archivoIndex);
//	    ArrayList<Hashes> listaCodificacion = new ArrayList<>();
//	    for(int j = 0; j < nombresMunis.length; j+=3) {
//	    	String xml2 = convertirJSONXML.leerArchivo("./ficherosXML//" + nombresMunis[j] + ".xml", "utf-8");
//	    	String acum = "";
//	    	String[] estacion = xml2.split("</" + nombresMunis[j] + ">");
//    		System.out.println("CIFRADO DE " + nombresMunis[j] + " INICIADO");
//	    	MessageDigest md;
//	    	try {
//	    		md = MessageDigest.getInstance("SHA");
//	    		String texto="", cifrado1="";
//	    		for(int i = 0; i < estacion.length; i++) {
//	    			texto += estacion[i];
//	    		}
//	    		byte dataBytes[] = texto.getBytes();
//	    		md.update(dataBytes);
//	    		byte resumen[] = md.digest();
//	    		for(byte b: resumen) {
//	    			cifrado1 += String.format("%02x", b);
//	    		}
//	    		Hashes h = new Hashes(nombresMunis[j], cifrado1);
//	    		listaCodificacion.add(h);
//	    		System.out.println("CIFRADO DE " + nombresMunis[j] + " TERMINADO");
//	    		//System.out.println("CIFRADO DE " + nombresMunis[j] + ": " + cifrado1);
//	    	} catch (NoSuchAlgorithmException e) {
//	    		// TODO Auto-generated catch block
//	    		e.printStackTrace();
//	    	}
//	    }
//	    for(Hashes im: listaCodificacion) {
//	    	if(im.getNomEstMet().equals("3_DE_MARZO")) {
//				im.setNomEstMet("3 DE MARZO");
//			} else if(im.getNomEstMet().equals("ALGORTA_BBIZI2")) {
//				im.setNomEstMet("ALGORTA (BBIZI2)");
//			} else if(im.getNomEstMet().equals("ANORGA")) {
//				im.setNomEstMet("AÑORGA");
//			} else if(im.getNomEstMet().equals("ARRAIZ_Monte")) {
//				im.setNomEstMet("ARRAIZ (Monte)");
//			} else if(im.getNomEstMet().equals("AV_GASTEIZ")) {
//				im.setNomEstMet("AV. GASTEIZ");
//			} else if(im.getNomEstMet().equals("AVDA_TOLOSA")) {
//				im.setNomEstMet("AVDA. TOLOSA");
//			} else if(im.getNomEstMet().equals("BANDERAS_meteo")) {
//				im.setNomEstMet("BANDERAS (meteo)");
//			} else if(im.getNomEstMet().equals("BOROA_METEO")) {
//				im.setNomEstMet("BOROA METEO");
//			} else if(im.getNomEstMet().equals("FERIA_meteo")) {
//				im.setNomEstMet("FERIA (meteo)");
//			} else if(im.getNomEstMet().equals("LAS_CARRERAS")) {
//				im.setNomEstMet("LAS CARRERAS");
//			} else if(im.getNomEstMet().equals("LOS_HERRAN")) {
//				im.setNomEstMet("LOS HERRAN");
//			} else if(im.getNomEstMet().equals("M_DIAZ_HARO")) {
//				im.setNomEstMet("Mª DIAZ HARO");
//			} else if(im.getNomEstMet().equals("SAN_JULIAN")) {
//				im.setNomEstMet("SAN JULIAN");
//			} else if(im.getNomEstMet().equals("SAN_MIGUEL")) {
//				im.setNomEstMet("SAN MIGUEL");
//			} else if(im.getNomEstMet().equals("ZELAIETA_PARQUE")) {
//				im.setNomEstMet("ZELAIETA PARQUE");
//			} else if(im.getNomEstMet().equals("ZIERBENA_Puerto")) {
//				im.setNomEstMet("ZIERBENA (Puerto)");
//			} else if(im.getNomEstMet().equals("ZUBIETA_METEO")) {
//				im.setNomEstMet("ZUBIETA METEO");
//			}
//	    	System.out.println(im.toString());
//	    }
//	    VolcarHashes.volcarInformacion(listaCodificacion);
	    
    	
    	//VOLCAR INFORMACION A LA BD CON HIBERNATE
    	
    	//MUNICIPIOS
    	String xmlMunicipios = convertirJSONXML.leerArchivo("./ficherosXML//municipios.xml", "utf-8");
    	ArrayList<Municipios> municipios = VolcarMunicipios.lecturaDatos(xmlMunicipios);
    	VolcarMunicipios.volcarInformacion(municipios);
    	
    	//ESTACIONES METEOROLOGICAS
    	String xmlEstaciones = convertirJSONXML.leerArchivo("./ficherosXML//estaciones.xml", "utf-8");
    	ArrayList<EstacionMeteorologica> estaciones = VolcarEstaciones.lecturaDatos(xmlEstaciones);
    	VolcarEstaciones.volcarInformacion(estaciones);
    	
    	//ESPACIOS NATURALES
    	String xmlEspaciosNaturales = convertirJSONXML.leerArchivo("./ficherosXML//espacios-naturales.xml", "utf-8");
    	ArrayList<EspacioNatural> espaciosNaturales = VolcarEspaciosNaturales.lecturaDatos(xmlEspaciosNaturales);
    	VolcarEspaciosNaturales.volcarInformacion(espaciosNaturales);
    	
    	//INFORMACION METEOROLOGICA
    	ArrayList<InformacionMeteorologica> listadoInfoMeteorologica = new ArrayList<InformacionMeteorologica>();
    	listadoInfoMeteorologica = VolcarInfoMeteorologica.lecturaDatos();
    	VolcarInfoMeteorologica.volcarInformacion(listadoInfoMeteorologica);
	}

}
