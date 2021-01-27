package ModAD;

import java.util.ArrayList;

public class VolcarInfoMeteorologica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xml = convertirJSONXML.leerArchivo("./ficherosXML//index.xml", "utf-8");
		String[] nombresMunicipios = obtenerNombreMunicipios(xml);
		for(int i = 0; i < nombresMunicipios.length; i+=3) {
			//System.out.println(nombresMunicipios[i]);
			//lecturaDatos("./ficherosXML//" + nombresMunicipios[i] + ".xml");
		}
		lecturaDatos("./ficherosXML//3_DE_MARZO.xml");
	}
	
	public static String[] obtenerNombreMunicipios(String archivo) {
		String nomMuni = "";
		String[] index, nodos, nombreMuni = null;

		index = archivo.split("</aggregated>");
		nombreMuni = new String[index.length - 1];
		
		for (int i = 0; i < index.length; i++) {
			nodos = index[i].split("/");
			for (int j = 0; j < nodos.length; j++) {
				if (nodos[j].contains("<name>")) {
					for (int k = 0; k < nodos[j].length(); k++) {		
						if (nodos[j].charAt(k) == 'e') {
							nomMuni = nodos[j].substring(k, nodos[j].length() - 1);
							if (nomMuni.contains(">")) {
								nombreMuni[i] = nomMuni.substring(2);
							}
						}
					}
				}
			}
		}
		return nombreMuni;
	}
	
	public static ArrayList<Municipios> lecturaDatos(String archivo) {
		Municipios[] munisObj;
		ArrayList<Municipios> listaMunicipios = new ArrayList<Municipios>();
		String municipio = "", alcalde = "", web = "";
		String[] index, municipios, nodos, nombreMuni = null;
		int[] idProv = null;
		
		String archivoIndex = convertirJSONXML.leerArchivo("./ficherosXML//index.xml", "utf-8");
		nombreMuni = obtenerNombreMunicipios(archivoIndex);

		for(int i = 0; i < nombreMuni.length; i+=3) {
			//System.out.println(nombreMuni[i]);
		}
		
		//for(int l = 0; l < nombreMuni.length; l+=3) {
			municipios = archivo.split("</3_DE_MARZO>");

			nombreMuni = new String[municipios.length - 1];
			idProv = new int[municipios.length - 1]; 
			munisObj = new Municipios[municipios.length - 1];
			for (int i = 0; i < municipios.length; i++) {
				nodos = municipios[i].split("/");
				for (int j = 0; j < nodos.length; j++) {
					if (nodos[j].contains("<Hour>")) {
						for (int k = 0; k < nodos[j].length(); k++) {		
							if (nodos[j].charAt(k) == 'r') {
								municipio = nodos[j].substring(k, nodos[j].length() - 1);
								if (municipio.contains(">")) {
									nombreMuni[i] = municipio.substring(2);
									System.out.println(nombreMuni[i]);
								}
							}
						}
					} else if (nodos[j].contains("<territorycode>")) {
						idProv[i] = Integer.parseInt(nodos[j].substring(23, nodos[j].length() - 1));
					} 
				}
			}
		//}
		

//		for (int i = 0; i < nombreMuni.length; i++) {
//			munisObj[i] = new Municipios(idProv[i], (i+1), nombreMuni[i], alcaldeMuni[i], webMuni[i]);
//			listaMunicipios.add(munisObj[i]);
//		}
		
		return listaMunicipios;
	}
	
}
