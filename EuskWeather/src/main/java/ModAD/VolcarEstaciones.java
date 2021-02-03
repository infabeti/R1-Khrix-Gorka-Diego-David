package ModAD;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import org.hibernate.Session;

public class VolcarEstaciones {
	
//	public static void main(String[] args) {
//		String xml = convertirJSONXML.leerArchivo("./ficherosXML//estaciones.xml", "utf-8");
//		lecturaDatos(xml);
//	}
	
	
	public static ArrayList<EstacionMeteorologica> lecturaDatos(String archivo) {
		EstacionMeteorologica[] estacionesObj;
		ArrayList<EstacionMeteorologica> listaEstaciones = new ArrayList<EstacionMeteorologica>();
		String nomEst = "", direccion = "", nomMuni="";
		String[] estaciones, nodos = null, nombreEst = null, direccEst = null, nombreMuni = null;
		double[] lati = null, longi = null;

		estaciones = archivo.split("</estacion>");
		nombreEst = new String[estaciones.length - 1];
		direccEst = new String[estaciones.length -1];
		nombreMuni = new String[estaciones.length -1];
		lati = new double[estaciones.length -1];
		longi = new double[estaciones.length -1];
		estacionesObj = new EstacionMeteorologica[estaciones.length - 1];
		
		for (int i = 0; i < estaciones.length; i++) {
			nodos = estaciones[i].split("/");
			for (int j = 0; j < nodos.length; j++) {
				if (nodos[j].contains("<Name>")) {
					for (int k = 0; k < nodos[j].length(); k++) {		
						if (nodos[j].charAt(k) == 'e') {
							nomEst = nodos[j].substring(k, nodos[j].length() - 1);
							if (nomEst.contains(">")) {
								nombreEst[i] = nomEst.substring(2);
							}
						}
					}
				} else if (nodos[j].contains("<Latitude>")) {
					
					String numLati = nodos[j].substring(29, nodos[j].length()-1);
					DecimalFormat formatter = new DecimalFormat("#.#");
					try {
						lati[i] = (double) formatter.parse(numLati);
						//System.out.println(lati[j]);
					} catch(ParseException e) {
						System.out.println(e.getMessage());
					}
					
				} else if (nodos[j].contains("<Longitude>")) {
					
					String numLongi = nodos[j].substring(20, nodos[j].length()-1);
					DecimalFormat formatter = new DecimalFormat("#.#");
					try {
						longi[i] = (double) formatter.parse(numLongi);
					} catch(ParseException e) {
						System.out.println(e.getMessage());
					}
					//System.out.println(Double.parseDouble(nodos[j].substring(20, nodos[j].length()-1)));
				
				} else if (nodos[j].contains("<Town>")) {
					for(int k = 0; k < nodos[j].length(); k++) {
						if(nodos[j].charAt(k) == 'n') {
							nomMuni = nodos[j].substring(k, nodos[j].length()-1);
							if (nomMuni.contains(">")) {
								nombreMuni[i] = nomMuni.substring(2);
								//System.out.println(nombreMuni[i]);
							}
						}
					}
				} 
			}
		}
		
		String[] aux;
		for(int i = 0; i < estaciones.length-1; i++) {
			nodos = estaciones[i].split("<Address>");		
			for(int j = 0; j < nodos.length; j++) {
				aux = nodos[j].split("</Address>");
				if(nodos[j].contains("</Address>")){
					direccEst[i] = aux[0];
				}
			}
		}
		
		for(int i = 0; i < nombreMuni.length; i++) {
			if(nombreMuni[i].contentEquals("Agurai")){
				nombreMuni[i] = "Salvatierra";
			}	
			if(nombreMuni[i].contentEquals("Laudi")) {
				nombreMuni[i] = "Laudio";
			}
			if(nombreMuni[i].contentEquals("Arrasat")) {
				nombreMuni[i] = "Arrasate";
			}
			if(nombreMuni[i].contentEquals("Valdegoví")) {
				nombreMuni[i] = "Villanueva de Valdegovía";
			}
		}

		for (int i = 0; i < nombreMuni.length; i++) {
			estacionesObj[i] = new EstacionMeteorologica((i+1), nombreEst[i], lati[i], longi[i], direccEst[i], nombreMuni[i]);
			listaEstaciones.add(estacionesObj[i]);
		}
		
		return listaEstaciones;
	}

	public static void volcarInformacion(ArrayList<EstacionMeteorologica> objetos) {
		
		for (int i = 0; i < objetos.size(); i++) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			//session.save(objetos.get(i));
			session.saveOrUpdate(objetos.get(i));
			session.getTransaction().commit();
			session.close();
			
		}
	}

}
