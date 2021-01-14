package EuskWeather;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class conexion {
	private static final String controlador = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.168.13.223:3306/datosmetereologicos";
	private static final String user = "root";
	private static final String passw = "";

	public static Connection conexionBBDD() {
		Connection conexion = null;

		try {
			Class.forName(controlador);
			conexion = (Connection) DriverManager.getConnection(URL, user, passw);
			System.out.println("Conectado");

//			 prueba conexion
//			ArrayList<String> nLineas = new ArrayList<String>();
//			String sql = "select Url from datosmetereologicos2.indexxml where Id = 1";
//
//			try {
//				java.sql.PreparedStatement ps = conexion.prepareStatement(sql);
//				// Statement ps=connection.conectarmySQL().createStatement();
//
//				ResultSet rs = ps.executeQuery("select Url from datosmetereologicos2.indexxml");
//
//				while (rs.next()) {
//					System.out.println(rs.getString(1));
//					nLineas.add(rs.getString(1));
//
//				}
//
//			} catch (Exception e) {
//				System.err.println("Consulta no valida");
//			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}

	public static void main(String[] args) {
		conexionBBDD();
	}
}
