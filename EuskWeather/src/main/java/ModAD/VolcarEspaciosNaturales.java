package ModAD;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;

import org.hibernate.Session;

public class VolcarEspaciosNaturales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String xml = convertirJSONXML.leerArchivo("./ficherosXML//espacios-naturales.xml", "utf-8"); 
		

		ArrayList<EspacioNatural> espaciosNaturales = lecturaDatos(xml);
//		for(EspacioNatural en: espaciosNaturales) {
//			System.out.println(en.getTipo());
//		}

		volcarInformacion(espaciosNaturales);
	}
	
	public static ArrayList<EspacioNatural> lecturaDatos(String archivo) {
		EspacioNatural[] espaciosNaturalesObj;
		ArrayList<EspacioNatural> listaEspaciosNaturales = new ArrayList<EspacioNatural>();
		String nomEspNat = "", descri = "", tipoEspNat="";
		String[] espaciosNats, nodos, nombreEspNat = null, descriEspNat = null, tipo = null;

		espaciosNats = archivo.split("</espacioNatural>");

		nombreEspNat = new String[espaciosNats.length - 1];
		descriEspNat = new String[espaciosNats.length -1];
		tipo = new String[espaciosNats.length -1];
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

		for (int i = 0; i < tipo.length; i++) {
			espaciosNaturalesObj[i] = new EspacioNatural((i+1), nombreEspNat[i], descriEspNat[i], tipo[i]);
			listaEspaciosNaturales.add(espaciosNaturalesObj[i]);
		}
		
		return listaEspaciosNaturales;
	}

	public static void volcarInformacion(ArrayList<EspacioNatural> objetos) {
		
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
