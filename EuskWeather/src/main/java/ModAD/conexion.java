package ModAD;

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
