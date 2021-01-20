package EuskWeather;

import java.util.ArrayList;

import org.hibernate.Session;

public class VolcarEstaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ArrayList<EstacionMeteorologica> lecturaDatos(String archivo) {
		Municipios[] munisObj;
		EstacionMeteorologica[] estacionesObj;
		ArrayList<EstacionMeteorologica> listaMunicipios = new ArrayList<EstacionMeteorologica>();
		String nomEst = "", direccion = "", nomMuni="";
		String municipio = "", alcalde = "", web = "";
		String[] municipios, nodos, nombreMuni = null, alcaldeMuni = null, webMuni = null;
		int[] idProv = null;

		municipios = archivo.split("</estacion>");

		nombreMuni = new String[municipios.length - 1];
		alcaldeMuni = new String[municipios.length -1];
		webMuni = new String[municipios.length -1];
		idProv = new int[municipios.length - 1]; 
		munisObj = new Municipios[municipios.length - 1];
		for (int i = 0; i < municipios.length; i++) {
			nodos = municipios[i].split("/");
			for (int j = 0; j < nodos.length; j++) {
				if (nodos[j].contains("<Town>")) {
					for (int k = 0; k < nodos[j].length(); k++) {		
						if (nodos[j].charAt(k) == 'n') {
							municipio = nodos[j].substring(k, nodos[j].length() - 1);
							if (municipio.contains(">")) {
								nombreMuni[i] = municipio.substring(2);
							}
						}
					}
				} else if (nodos[j].contains("<Latitude>")) {
					for(int k = 0; k < nodos[j].length(); k++) {
						if(nodos[j].charAt(k) == 'e') {
							alcalde = nodos[j].substring(k, nodos[j].length() -1);
							if (alcalde.contains(">")) {
								alcaldeMuni[i] = alcalde.substring(2);
							}
						}
					}
				} else if (nodos[j].contains("<Longitude>")) {
					for(int k = 0; k < nodos[j].length(); k++) {
						if(nodos[j].charAt(k) == 'e') {
							web = nodos[j].substring(k, nodos[j].length() -1);
							if (web.contains(">")) {
								webMuni[i] = web.substring(2);
							}
						}
					}
				} else if(nodos[j].contains("<Address>")){
					for(int k = 0; k < nodos[j].length(); k++) {
						if(nodos[j].charAt(k) == 'e') {
							web = nodos[j].substring(k, nodos[j].length() -1);
							if (web.contains(">")) {
								webMuni[i] = web.substring(2);
							}
						}
					}
				} else if (nodos[j].contains("<Province>")) {
					idProv[i] = Integer.parseInt(nodos[j].substring(23, nodos[j].length() - 1));
				} 
			}
		}
		
		for(int i = 0; i < nombreMuni.length; i++) {
			for(int j = i+1; j < nombreMuni.length; j++) {
				if(nombreMuni[i].contentEquals(nombreMuni[j])){
					nombreMuni[j] = nombreMuni[j] + "-DUP";
				}
				if(nombreMuni[i].contentEquals("San Sebastián")){
					nombreMuni[i] = nombreMuni[i] + "-DUP";
				}	
			}
		}

		for (int i = 0; i < nombreMuni.length; i++) {
			munisObj[i] = new Municipios(idProv[i], (i+1), nombreMuni[i], alcaldeMuni[i], webMuni[i]);
			//listaMunicipios.add(munisObj[i]);
		}
		
		return listaMunicipios;
	}

	public static void volcarInformacion(ArrayList<Municipios> objetos) {
		
		for (int i = 0; i < objetos.size(); i++) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(objetos.get(i));
			session.getTransaction().commit();
			session.close();
			
		}
		HibernateUtil.shutdown();
	}

}
