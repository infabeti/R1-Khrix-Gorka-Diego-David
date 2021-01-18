package EuskWeather;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
		String sql = "", resultadoConsulta = "";
		
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

				resultadoConsulta = consultarDato.consultarUsuarios(sql);
				
				salida.writeObject(resultadoConsulta);
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Fin Servidor");
			System.exit(0);
		}
	}
}
