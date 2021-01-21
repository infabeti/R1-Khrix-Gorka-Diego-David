package ModAD;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

public class DescargarPrincipales {
	
		public static void main(String[] args) {	
			descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/index.json", "./archJSON//index.json");
			descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_informes_estudios/calidad_aire_2020/es_def/adjuntos/estaciones.json", "./archJSON//estaciones.json");
			descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_recursos_turisticos/playas_de_euskadi/opendata/espacios-naturales.json", "./archJSON//espacios-naturales.json");
			descargarFicheros("https://opendata.euskadi.eus/contenidos/ds_registros/registro_entidades_locales/opendata/entidades.json", "./archJSON//municipios.json");
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
}
