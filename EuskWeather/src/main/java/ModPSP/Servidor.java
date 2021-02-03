package ModPSP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import EuskWeatherApp.Ejecutable;
import VistaPSP.VentanaCliente;

public class Servidor extends Thread{
private int PUERTO = 5000;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ejecutable ej = new Ejecutable();
		try {
			ej.ejecutable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
				
				while(VentanaCliente.SALIR == false) {
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
					if(sql.contains("from EstacionMeteorologica")) {
						resultadoConsulta = consultarDato.consultarEstaciones(sql);
					}
					if(sql.contains("from InformacionMeteorologica")) {
						resultadoConsulta = consultarDato.consultarInfoMeteo(sql);
					}
					if(sql.contains("from EspaciosNaturales")) {
						resultadoConsulta = consultarDato.consultarEspacio(sql);
					}
					salida.writeObject(resultadoConsulta);
				}
			}

		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Fin Servidor");
			System.exit(0);
		}
	}
}
