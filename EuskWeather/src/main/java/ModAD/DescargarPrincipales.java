package ModAD;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Scanner;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public class DescargarPrincipales {
	
	public void verificarInformacion(String nomFichero) {
		
			String fichWeb = "";
			if(nomFichero.equals("index") || nomFichero.equals("estaciones")) {
				 fichWeb = leerURL("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/" + nomFichero + ".json");
			} else if(nomFichero.equals("espacios-naturales")) {
				fichWeb = leerURL("https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/playas_de_euskadi/opendata/" + nomFichero + ".json");
			} else if(nomFichero.equals("municipios")) {
				fichWeb = leerURL("https://opendata.euskadi.eus/contenidos/ds_registros/registro_entidades_locales/opendata/entidades.json");
			}
			
			String aux = convertirJSONXML.leerArchivo("./archJSON//" + nomFichero + ".json", "Windows-1252");

			MessageDigest md;
			String cifrado1 = "", cifrado2 = "";
			try {
				md = MessageDigest.getInstance("SHA");
				byte dataBytes[] = aux.getBytes();
				md.update(dataBytes);
				byte resumen[] = md.digest();
				for(byte b: resumen) {
					cifrado1 += String.format("%02x", b);
				}
				
				byte dataWeb[] = fichWeb.getBytes();
				md.update(dataWeb);
				byte resumenWeb[] = md.digest();
				for(byte b: resumenWeb) {
					cifrado2 += String.format("%02x", b);
				}
//				System.out.println(nomFichero + " local: " + cifrado1);
//				System.out.println(nomFichero + " web: " + cifrado2);
				File f = new File("./ficherosXML//" + nomFichero + ".xml");
				if(cifrado1.contentEquals(cifrado2)) {
					System.out.println(nomFichero + ".json ESTA ACTUALIZADO");
				} else {
					f.delete();
					System.out.println("HAY QUE ACTUALIZAR el fichero " + nomFichero);
					if(nomFichero.equals("index") || nomFichero.equals("estaciones")) {
						 descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/" + nomFichero + ".json", "./archJSON//" + nomFichero + ".json");
					} else if(nomFichero.equals("espacios-naturales")) {
						descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/playas_de_euskadi/opendata/" + nomFichero + ".json", "./archJSON//" + nomFichero + ".json");
					} else if(nomFichero.equals("municipios")) {
						descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_registros/registro_entidades_locales/opendata/entidades.json", "./archJSON//" + nomFichero + ".json");
					}
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
		private static void trustEveryone() {
			try {
				HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
					public boolean verify(String hostname, SSLSession session) {
						return true;
					}
				});
				SSLContext context = SSLContext.getInstance("TLS");
				context.init(null, new X509TrustManager[] { new X509TrustManager() {
					public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					}

					public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					}

					public X509Certificate[] getAcceptedIssuers() {
						return new X509Certificate[0];
					}
				} }, new SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }

	    public static void descargarFicheros(String direccion, String archivoSalida) {
	    	try {
	    		trustEveryone();
	    		URL url = new URL(direccion);
	    		URLConnection urlCon = url.openConnection();

	    		System.out.println("Descargado fichero: " + archivoSalida);

	    		InputStream is = urlCon.getInputStream();
	    		FileOutputStream fos = new FileOutputStream(archivoSalida);

	    		byte[] array = new byte[1000];
	    		int leido = is.read(array);
	    		while (leido > 0) {
	    			fos.write(array, 0, leido);
	    			leido = is.read(array);
	    		}
	    		is.close();
	    		fos.close();	
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    }
	    
	    public static String leerURL(String direccion) {
	    	String cadena = "";
	    	try {
	    		trustEveryone();
	    		URL url = new URL(direccion);
	    		URLConnection urlCon = url.openConnection();
	    		InputStream is = urlCon.getInputStream();	    		
	    				
	    		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("Windows-1252")));
	    		StringBuilder acum = new StringBuilder();
	    		
	    		int cont = 0;
	    		while((cont = br.read()) != -1) {
	    			char ch = (char) cont;
	    			acum.append(ch);
	    		}
	    		cadena = acum.toString();
	    		
	    		is.close();
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	
	    	return cadena;
	    }
}
