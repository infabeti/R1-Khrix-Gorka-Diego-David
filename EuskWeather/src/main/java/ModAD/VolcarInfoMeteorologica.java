package ModAD;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import org.hibernate.Session;

public class VolcarInfoMeteorologica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xml = convertirJSONXML.leerArchivo("./ficherosXML//index.xml", "utf-8");
		String[] nombresMunicipios = obtenerNombreMunicipios(xml);
		ArrayList<InfoMeteorologica> listadoInfoMeteorologica = new ArrayList<InfoMeteorologica>();
			
		listadoInfoMeteorologica = lecturaDatos();
		cambiarNombreEstacion(listadoInfoMeteorologica);
//		for(InfoMeteorologica i: listadoInfoMeteorologica) {
//			System.out.println(i.toString());
//		}
		
		volcarInformacion(listadoInfoMeteorologica);
		
	}
	
	public static void cambiarNombreEstacion(ArrayList<InfoMeteorologica> lista) {
		for(InfoMeteorologica im: lista) {
			if(im.getNomEstMet().equals("3_DE_MARZO")) {
				im.setNomEstMet("3 DE MARZO");
			} else if(im.getNomEstMet().equals("ALGORTA_BBIZI2")) {
				im.setNomEstMet("ALGORTA (BBIZI2)");
			} else if(im.getNomEstMet().equals("ANORGA")) {
				im.setNomEstMet("AÑORGA");
			} else if(im.getNomEstMet().equals("ARRAIZ_Monte")) {
				im.setNomEstMet("ARRAIZ (Monte)");
			} else if(im.getNomEstMet().equals("AV_GASTEIZ")) {
				im.setNomEstMet("AV. GASTEIZ");
			} else if(im.getNomEstMet().equals("AVDA_TOLOSA")) {
				im.setNomEstMet("AVDA. TOLOSA");
			} else if(im.getNomEstMet().equals("BANDERAS_meteo")) {
				im.setNomEstMet("BANDERAS (meteo)");
			} else if(im.getNomEstMet().equals("BOROA_METEO")) {
				im.setNomEstMet("BOROA METEO");
			} else if(im.getNomEstMet().equals("FERIA_meteo")) {
				im.setNomEstMet("FERIA (meteo)");
			} else if(im.getNomEstMet().equals("LAS_CARRERAS")) {
				im.setNomEstMet("LAS CARRERAS");
			} else if(im.getNomEstMet().equals("LOS_HERRAN")) {
				im.setNomEstMet("LOS HERRAN");
			} else if(im.getNomEstMet().equals("M_DIAZ_HARO")) {
				im.setNomEstMet("Mª DIAZ HARO");
			} else if(im.getNomEstMet().equals("SAN_JULIAN")) {
				im.setNomEstMet("SAN JULIAN");
			} else if(im.getNomEstMet().equals("SAN_MIGUEL")) {
				im.setNomEstMet("SAN MIGUEL");
			} else if(im.getNomEstMet().equals("ZELAIETA_PARQUE")) {
				im.setNomEstMet("ZELAIETA PARQUE");
			} else if(im.getNomEstMet().equals("ZIERBENA_Puerto")) {
				im.setNomEstMet("ZIERBENA (Puerto)");
			} else if(im.getNomEstMet().equals("ZUBIETA_METEO")) {
				im.setNomEstMet("ZUBIETA METEO");
			}
		}
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
	
	public static ArrayList<InfoMeteorologica> lecturaDatos() {
		InfoMeteorologica[] infoMeteoObj;
		ArrayList<InfoMeteorologica> listaInfo = new ArrayList<InfoMeteorologica>();
		String estaciones = "";
		String[] estacion, nodos, fechasTotales = null, fechasBD = null;
		String[] calidadAire = null, calidadBD = null, nombreMuni = null, horaTotales = null, horasBD = null;
		String[] tempC = null, tempBD = null;
		int[] satO2 = null, satBD = null;
		String[] presionAtm = null, presionBD = null;
		ArrayList<InfoMeteorologica> listado = new ArrayList<InfoMeteorologica>();
		
		String archivoIndex = convertirJSONXML.leerArchivo("./ficherosXML//index.xml", "utf-8");
		nombreMuni = obtenerNombreMunicipios(archivoIndex);
//		for(int i = 0; i < nombreMuni.length; i+=3) {
//			System.out.println(nombreMuni[i]);
//		}
		infoMeteoObj = new InfoMeteorologica[nombreMuni.length];
		satO2 = new int[nombreMuni.length]; 
		fechasTotales = new String[nombreMuni.length];
		horaTotales = new String[nombreMuni.length];
		presionAtm = new String[nombreMuni.length];
		tempC = new String[nombreMuni.length];
		calidadAire = new String[nombreMuni.length];
		for(int l = 0; l < nombreMuni.length; l+=3) {
			String xml2 = convertirJSONXML.leerArchivo("./ficherosXML//" + nombreMuni[l] + ".xml", "utf-8");
			estacion = xml2.split("</" + nombreMuni[l] + ">");
			
			for (int i = 0; i < estacion.length; i++) {
				nodos = estacion[i].split("/");
				for (int j = 0; j < nodos.length; j++) {
					if (nodos[j].contains("<Hour>")) {
						for (int k = 0; k < nodos[j].length(); k++) {		
							if (nodos[j].charAt(k) == 'r') {
								estaciones = nodos[j].substring(k, nodos[j].length() - 1);
								if (estaciones.contains(">")) {
									horaTotales[l] = estaciones.substring(2);
									
								}
							}
						}
					}
				}
			}
			horasBD = new String[1];
			for(int i = 0; i < horasBD.length; i++) {
				horasBD[i] = horaTotales[i];
				//System.out.println(horasBD[i]);
			}
			
			for(int i = 0; i < 3; i++) {
				if(estacion[i].contains("<TC>")) {
					nodos = estacion[i].split("<TC>");		
					for(int j = 0; j < nodos.length; j++) {
						String[] temperatura = nodos[j].split("</TC>");
						if(nodos[j].contains("</TC>")){
							tempC[i] = temperatura[0];
						}
					}
				} else {
					tempC[i] = "Datos no disponibles";
				}
				
			}
			tempBD = new String[1];
			for(int i = 0; i < tempBD.length; i++) {
				tempBD[i] = tempC[i];
			}
			
			for(int i = 0; i < 3; i++) {
				nodos = estacion[i].split("<PM10>");		
				for(int j = 0; j < nodos.length; j++) {
					String[] numPresion = nodos[j].split("</PM10>");
					if(nodos[j].contains("</PM10>")){
						presionAtm[i] = numPresion[0];
					}
				}
			}
			presionBD = new String[1];
			for(int i = 0; i < presionBD.length; i++) {
				presionBD[i] = presionAtm[i];
				//System.out.println(presionBD[i]);
			}
			
			for(int i = 0; i < 3; i++) {
				nodos = estacion[i].split("<SO2>");		
				for(int j = 0; j < nodos.length; j++) {
					String[] numSat = nodos[j].split("</SO2>");
					if(nodos[j].contains("</SO2>")){
						satO2[i] = Integer.parseInt(numSat[0]);
					}
				}
			}
			satBD = new int[1];
			for(int i = 0; i < satBD.length; i++) {
				satBD[i] = satO2[i];
			}
			
			for(int i = 0; i < estacion.length-1; i++) {
				nodos = estacion[i].split("<PM25ICA>");		
				for(int j = 0; j < nodos.length; j++) {
					String[] calidad = nodos[j].split("</PM25ICA>");
					if(nodos[j].contains("</PM25ICA>")){
						calidadAire[l] = calidad[0];
					}
				}
			}
			calidadBD = new String[1];
			for(int i = 0; i < calidadBD.length; i++) {
				calidadBD[i] = calidadAire[i];
			}
			
			String[] aux;
			for(int i = 0; i < estacion.length-1; i++) {
				nodos = estacion[i].split("<Date>");		
				for(int j = 0; j < nodos.length; j++) {
					aux = nodos[j].split("</Date>");
					if(nodos[j].contains("</Date>")){
						fechasTotales[l] = aux[0];
						//System.out.println(fechasTotales[i]);
					}
				}
			}
			
			fechasBD = new String[1];
			for(int i = 0; i < fechasBD.length; i++) {
				fechasBD[i] = fechasTotales[i];
				//System.out.println(fechasBD[0]);
			}
			
			infoMeteoObj[l] = new InfoMeteorologica((l+1), fechasBD[0], horasBD[0], presionBD[0], tempBD[0], satBD[0], calidadBD[0], nombreMuni[l]);
			
			listado.add(infoMeteoObj[l]);
		}
		//System.out.println(listado.get(58).toString());
		
		return listado;
	}
	
	public static void volcarInformacion(ArrayList<InfoMeteorologica> objetos) {
		
		cambiarNombreEstacion(objetos);
		
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
