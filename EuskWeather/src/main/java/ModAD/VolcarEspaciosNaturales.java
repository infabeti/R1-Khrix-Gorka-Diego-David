package ModAD;

import java.util.ArrayList;

import org.hibernate.Session;

public class VolcarEspaciosNaturales {
	
	public static ArrayList<EspacioNatural> lecturaDatos(String archivo) {
		EspacioNatural[] espaciosNaturalesObj;
		ArrayList<EspacioNatural> listaEspaciosNaturales = new ArrayList<EspacioNatural>();
		String nomEspNat = "", descri = "", tipoEspNat="", nomMuni = "";
		String[] espaciosNats, nodos, nombreEspNat = null, descriEspNat = null, tipo = null, nomMunicipio = null;

		espaciosNats = archivo.split("</espacioNatural>");

		nombreEspNat = new String[espaciosNats.length - 1];
		descriEspNat = new String[espaciosNats.length -1];
		tipo = new String[espaciosNats.length -1];
		nomMunicipio = new String[espaciosNats.length -1];
		espaciosNaturalesObj = new EspacioNatural[espaciosNats.length-1];
		
		for (int i = 0; i < espaciosNats.length; i++) {
			nodos = espaciosNats[i].split("/");
			for (int j = 0; j < nodos.length; j++) {
				if (nodos[j].contains("<documentName>")) {
					for (int k = 0; k < nodos[j].length(); k++) {		
						if (nodos[j].charAt(k) == 'e') {
							nomEspNat = nodos[j].substring(k, nodos[j].length() - 1);
							if (nomEspNat.contains(">")) {
								nombreEspNat[i] = nomEspNat.substring(2);
							}
						}
					}
				}else if(nodos[j].contains("<turismDescription>")){
					for(int k = 0; k < nodos[j].length(); k++) {
						if(nodos[j].charAt(k) == 'n') {
							descri = nodos[j].substring(k, nodos[j].length()-1);
							if (descri.contains(">")) {
								descriEspNat[i] = descri.substring(2);
							}
						}
					}
				} else if (nodos[j].contains("<natureType>")) {
					for(int k = 0; k < nodos[j].length(); k++) {
						if(nodos[j].charAt(k) == 'e') {
							tipoEspNat = nodos[j].substring(k, nodos[j].length()-1);
							if (tipoEspNat.contains(">")) {
								tipo[i] = tipoEspNat.substring(2);
							}
						}
					}
				} 
			}
		}
		
		String[] aux;
		for(int i = 0; i < espaciosNats.length-1; i++) {
			nodos = espaciosNats[i].split("<municipality>");		
			for(int j = 0; j < nodos.length; j++) {
				aux = nodos[j].split("</municipality>");
				if(nodos[j].contains("</municipality>")){
					nomMunicipio[i] = aux[0];
					//System.out.println(nomMunicipio[i]);
				}
			}
		}
		
		for(int i= 0; i < nomMunicipio.length; i++) {
			if(nomMunicipio[i].contentEquals("Ayala/Aiara")) {
				nomMunicipio[i] = "Aia";
			}
			if(nomMunicipio[i].contentEquals("Arratzua-Ubarrundia")) {
				nomMunicipio[i] = "Arratzu";
			}
			if(nomMunicipio[i].contentEquals("Otxandio Legutio Legutio Legutio")) {
				nomMunicipio[i] = "Legutio";
			}
			if(nomMunicipio[i].contentEquals("Valdegovía/Gaubea")) {
				nomMunicipio[i] = "Villanueva de Valdegovía";
			}
			if(nomMunicipio[i].contentEquals("Campezo/Kanpezu")) {
				nomMunicipio[i] = "Karkamu";
			}
			if(nomMunicipio[i].contentEquals("Getxo Sopela")) {
				nomMunicipio[i] = "Sopela";
			}
			if(nomMunicipio[i].contentEquals("Zierbena Muskiz")) {
				nomMunicipio[i] = "Zierbena";
			}
			if(nomMunicipio[i].contentEquals("Donostia / San Sebastián")) {
				nomMunicipio[i] = "Donostia";
			}
			if(nomMunicipio[i].contentEquals("Sukarrieta Busturia")) {
				nomMunicipio[i] = "Sukarrieta";
			}
			if(nomMunicipio[i].contentEquals("Barrundia Elburgo/Burgelu")) {
				nomMunicipio[i] = "Elburgo";
			}
		}

		for (int i = 0; i < tipo.length; i++) {
			espaciosNaturalesObj[i] = new EspacioNatural((i+1), nombreEspNat[i], descriEspNat[i], tipo[i], nomMunicipio[i]);
			listaEspaciosNaturales.add(espaciosNaturalesObj[i]);
		}
		
		return listaEspaciosNaturales;
	}

	public static void volcarInformacion(ArrayList<EspacioNatural> objetos) {
		
		for (int i = 0; i < objetos.size(); i++) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			//session.save(objetos.get(i));
			session.saveOrUpdate(objetos.get(i));
			session.getTransaction().commit();
			session.close();
			
		}
		//HibernateUtil.shutdown();
	}

}
