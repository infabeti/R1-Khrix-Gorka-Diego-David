package ModPSP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor extends Thread{
private int PUERTO = 5000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Servidor s = new Servidor();
		s.start();
	}
	
	@Override
	public void run() {
		ObjectInputStream entrada = null;
		ObjectOutputStream salida = null;
		ServerSocket servidor = null;
		Socket cliente = null;
		String sql = "";
		ArrayList resultadoConsulta = null;
		try {
			servidor = new ServerSocket(PUERTO);

			System.out.println("Servidor iniciado...");
			Socket socket = new Socket();
			
			while (true) {
				socket = servidor.accept();
				salida = new ObjectOutputStream(socket.getOutputStream());
				entrada = new ObjectInputStream(socket.getInputStream());
				System.out.println("CLIENTE CONECTADO");
				
				sql = (String) entrada.readObject();
				
				if(sql.contains("from Usuarios")) {
					resultadoConsulta = consultarDato.consultarUsuarios(sql);
				}
				if(sql.contains("from Municipios")) {
					resultadoConsulta = consultarDato.consultarMunicipios(sql);
				}
				if(sql.contains("from Provincias")) {
					resultadoConsulta = consultarDato.consultarProvincias(sql);
				}
				salida.writeObject(resultadoConsulta);
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Fin Servidor");
			System.exit(0);
		}
	}
}
