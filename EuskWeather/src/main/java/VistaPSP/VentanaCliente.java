package VistaPSP;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ModAD.Municipios;
import ModAD.Provincias;
import ModAD.Usuarios;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class VentanaCliente extends JFrame{
	
	private JPanel contentPane;
	private static String sql;
	private final static int PUERTO = 5000;
	private final static String IP = "localhost";
	private static Socket cliente = null;
	private static ObjectInputStream entrada = null;
	private static ObjectOutputStream salida = null;
	public static JComboBox comboBox;
	
	public static void main(String[] args) {
			
		VentanaCliente vc = new VentanaCliente();
		vc.setVisible(true);
		
	}
	
	public static void cargarComboBox() {
		
		sql = "select p from Provincias p";
		Provincias prov = new Provincias();
		ArrayList<Provincias> resultCons;
		try {
			entrada = new ObjectInputStream(cliente.getInputStream());
			salida = new ObjectOutputStream(cliente.getOutputStream());
			salida.writeObject(sql);
				
			
			try {
				ArrayList resultado = (ArrayList) entrada.readObject();
			
				Iterator<Provincias> it = resultado.iterator();
				while(it.hasNext()) {
					prov = it.next();
					comboBox.addItem(prov.getNombreProv());
					
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
			
		}catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public VentanaCliente() {

			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVerUsuarios = new JButton("VER TODOS USUARIOS");
		btnVerUsuarios.setBounds(10, 439, 185, 23);
		contentPane.add(btnVerUsuarios);
		
		JButton btnModificar = new JButton("MODIFICAR DIRECCION");
		btnModificar.setBounds(10, 507, 185, 23);
		contentPane.add(btnModificar);
		
		JButton btnMunicipiosConEstaciones = new JButton("MUNICIPIOS CON ESTACIONES");
		
		btnMunicipiosConEstaciones.setBounds(10, 473, 185, 23);
		contentPane.add(btnMunicipiosConEstaciones);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 603, 417);
		contentPane.add(textArea);
		
		comboBox = new JComboBox();
		comboBox.setBounds(205, 473, 129, 22);
		contentPane.add(comboBox);
		
		try {
			cliente = new Socket(IP, PUERTO);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("Conexion realizada con el servidor.");
		cargarComboBox();
		
		btnVerUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub		
				
			sql = "select u from Usuarios u";
			Usuarios users = new Usuarios();
			ArrayList<Usuarios> resultCons;
			try {
				entrada = new ObjectInputStream(cliente.getInputStream());
				salida = new ObjectOutputStream(cliente.getOutputStream());
				salida.writeObject(sql);
					
				ArrayList resultado = (ArrayList) entrada.readObject();
					
				Iterator<Usuarios> it = resultado.iterator();
				while(it.hasNext()) {
				users = it.next();
				textArea.setText(textArea.getText()+
						"ID: "+users.getidUser()+
						"\nNombre y Apellidos: "+users.getnombreApellido()+
						"\nDireccion: "+users.getDireccion()+
						"\nMail: "+users.getMail()+
						"\nNick: "+users.getNickUsuario()+
						"\nContraseña: "+users.getContrasenia()+
						"\n----------------------------------------------------------------");
					
				}
										
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
});
		btnMunicipiosConEstaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String provincia = null;
				if(comboBox.getSelectedItem().equals("Araba/Álava")) {
					provincia = "1";
				}
				if(comboBox.getSelectedItem().equals("Gipuzkoa")) {
					provincia = "20";
				}
				if(comboBox.getSelectedItem().equals("Bizkaia")) {
					provincia = "48";
				}
				if(comboBox.getSelectedItem().equals("ProvPrueba")) {
					provincia = "2";
				}
				
				
				sql = "select m from Municipio m where m.idProv = " + provincia;
				Municipios munic = new Municipios();
				ArrayList<Municipios> resultCons;
				try {
					entrada = new ObjectInputStream(cliente.getInputStream());
					salida = new ObjectOutputStream(cliente.getOutputStream());
					salida.writeObject(sql);
					
					ArrayList resultado = (ArrayList) entrada.readObject();
					
					Iterator<Municipios> it = resultado.iterator();
					while(it.hasNext()) {
					munic = it.next();
					textArea.setText(textArea.getText()+
							"ID: "+munic.getIdMunicipio()+
							"\nNombre del municipio: "+munic.getNombreMuni()+
							"\nAlcalde: "+munic.getAlcaldeMuni()+
							"\nWeb: "+munic.getWebMuni()+
							"\nNick: "+munic.getIdProv()+ 
							"\n----------------------------------------------------------------");
						
					}
					
				}catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	}
}
