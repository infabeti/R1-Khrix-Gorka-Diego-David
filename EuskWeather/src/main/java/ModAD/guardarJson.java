package ModAD;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class guardarJson {

	public static void main(String[] args) throws Exception {
		ArrayList<String> arraylist;
		ArrayList<String> arrayNombres;
		arraylist = guardarJsonIndex();
		arrayNombres = guardarNombreJsonIndex();
		trustAllCerts();
		for (int i = 0; i < arraylist.size(); i++) {

			System.out.println(arraylist.get(i).toString());
			try {
				// Url con la foto
				URL url = new URL(arraylist.get(i));

				// establecemos conexion
				URLConnection urlCon = url.openConnection();

				// Sacamos por pantalla el tipo de fichero
				System.out.println(urlCon.getContentType());

				// Se obtiene el inputStream de la foto web y se abre el fichero
				// local.
				InputStream is = urlCon.getInputStream();
				FileOutputStream fos = new FileOutputStream("./ficheros//" + i + ".json");

				// Lectura de la foto de la web y escritura en fichero local
				byte[] array = new byte[1000]; // buffer temporal de lectura.
				int leido = is.read(array);
				while (leido > 0) {
					fos.write(array, 0, leido);
					leido = is.read(array);
				}

				// cierre de conexion y fichero.
				is.close();
				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static ArrayList<String> guardarJsonIndex() {
		Connection con = conexion.conexionBBDD();
		// prueba conexion
		ArrayList<String> nLineas = new ArrayList<String>();
		String sql = "select Url from datosmetereologicos.indextuneado3";

		try {
			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			Statement ps2 = (Statement) conexion.conexionBBDD().createStatement();
			java.sql.ResultSet rs = (java.sql.ResultSet) ps2.executeQuery("select Url from datosmetereologicos.indextuneado3");

			while (rs.next()) {
				// System.out.println(rs.getString(1));
				nLineas.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("Consulta no valida");
		}
		return nLineas;
	}

	public static ArrayList<String> guardarNombreJsonIndex() {
		Connection con = conexion.conexionBBDD();
		// prueba conexion
		ArrayList<String> nombres = new ArrayList<String>();
		String sql = "select Nombre from datosmetereologicos.indextuneado3";

		try {
			java.sql.PreparedStatement ps = con.prepareStatement(sql);
			Statement ps2 = (Statement) conexion.conexionBBDD().createStatement();
			java.sql.ResultSet rs = (java.sql.ResultSet) ps2.executeQuery("select Nombre from datosmetereologicos.indextuneado3");

			while (rs.next()) {
				// System.out.println(rs.getString(1));
				nombres.add(rs.getString(1));
			}
		} catch (Exception e) {
			System.err.println("Consulta no valida");
		}
		return nombres;
	}

	public static void trustAllCerts() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(X509Certificate[] certs, String authType) {
				
			}

			@Override
			public void checkServerTrusted(X509Certificate[] certs, String authType) {
				
			}
		} };

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {

			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}
	
}