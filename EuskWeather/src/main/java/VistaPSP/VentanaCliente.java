package VistaPSP;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import ModAD.EstacionMeteorologica;
import ModAD.Municipios;
import ModAD.Provincias;
import ModAD.Usuarios;

import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

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
	public JComboBox comboBox;
	public static boolean SALIR = false;
	
	public static void main(String[] args) {
			
		VentanaCliente vc = new VentanaCliente();
		vc.setVisible(true);
		
	}
	
	public static void cargarComboBox(JComboBox comboBox, ObjectInputStream entrada, ObjectOutputStream salida) {
		
		sql = "select p from Provincias p";
		Provincias prov = new Provincias();
		ArrayList<Provincias> resultCons;
		try {
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
	
	public static void cargarComboBoxMunicipios(JComboBox comboBox, String codProv, ObjectInputStream entrada, ObjectOutputStream salida) {
		
		sql = "select m from Municipios m where m.idProv = " + codProv;
		Municipios muni = new Municipios();
		try {
			salida.writeObject(sql);
				
			try {
				ArrayList resultado = (ArrayList) entrada.readObject();
			
				Iterator<Municipios> it = resultado.iterator();
				while(it.hasNext()) {
					muni = it.next();
					comboBox.addItem(muni.getNombreMuni());
					
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
		
		JButton btnEstaciones = new JButton("ESTACIONES  METEOROLOGICAS DE");
		btnEstaciones.setBounds(10, 507, 226, 23);
		contentPane.add(btnEstaciones);
		
		JButton btnMunicipiosConEstaciones = new JButton("MUNICIPIOS DE");
		
		btnMunicipiosConEstaciones.setBounds(10, 473, 185, 23);
		contentPane.add(btnMunicipiosConEstaciones);
		
		JTextArea textArea = new JTextArea();
		JScrollPane sp = new JScrollPane(textArea);
		sp.setBounds(10,11,603,417);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(sp);
		
		comboBox = new JComboBox();
		comboBox.setBounds(205, 473, 129, 22);
		contentPane.add(comboBox);
		
		JComboBox comboBoxMunis = new JComboBox();
		comboBoxMunis.setBounds(246, 507, 147, 22);
		contentPane.add(comboBoxMunis);
		
		try {
			cliente = new Socket(IP, PUERTO);
			entrada = new ObjectInputStream(cliente.getInputStream());
			salida = new ObjectOutputStream(cliente.getOutputStream());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.out.println("Conexion realizada con el servidor.");
		cargarComboBox(comboBox, entrada, salida);
		
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				comboBoxMunis.removeAllItems();
				String codProv = null;
				if(comboBox.getSelectedItem().equals("Araba/Álava")) {
					codProv = "1";
				}
				if(comboBox.getSelectedItem().equals("Gipuzkoa")) {
					codProv = "20";
				}
				if(comboBox.getSelectedItem().equals("Bizkaia")) {
					codProv = "48";
				}
				cargarComboBoxMunicipios(comboBoxMunis, codProv, entrada, salida);
			}
			
		});
		
		btnVerUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub		
				
			textArea.setText("");
			sql = "select u from Usuarios u";
			Usuarios users = new Usuarios();
			ArrayList<Usuarios> resultCons;
			try {
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
						"\n----------------------------------------------------------------\n");
					
				}
										
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		});
		
		btnMunicipiosConEstaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String codProv = null;
				if(comboBox.getSelectedItem().equals("Araba/Álava")) {
					codProv = "1";
				}
				if(comboBox.getSelectedItem().equals("Gipuzkoa")) {
					codProv = "20";
				}
				if(comboBox.getSelectedItem().equals("Bizkaia")) {
					codProv = "48";
				}
				//cargarComboBoxMunicipios(comboBoxMunis, codProv, entrada, salida);
				
				sql = "select m from Municipios m where m.idProv = " + codProv;
				Municipios munic = new Municipios();
				ArrayList<Municipios> resultCons;
				try {
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
							"\nCodProv: "+munic.getIdProv()+ 
							"\n----------------------------------------------------------------\n");
						
					}
					
				}catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		btnEstaciones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				textArea.setText("");
				sql = "select e from EstacionMeteorologica e where e.nomMunicipio = '" + comboBoxMunis.getSelectedItem() + "'";
				EstacionMeteorologica estacion = new EstacionMeteorologica();
				ArrayList<EstacionMeteorologica> resultCons;
				try {
					salida.writeObject(sql);
					
					ArrayList resultado = (ArrayList) entrada.readObject();
					
					Iterator<EstacionMeteorologica> it = resultado.iterator();
					while(it.hasNext()) {
					estacion = it.next();
					textArea.setText(textArea.getText()+
							"ID: "+estacion.getIdEstacion()+
							"\nNombre de la estacion: "+estacion.getNombreEstacion()+
							"\nLatitud: "+estacion.getLatidud()+
							"\nLongitud: "+estacion.getLongitud()+
							"\nDireccion: "+estacion.getDireccion()+ 
							"\nMunicipio perteneciente: "+estacion.getNomMunicipio() +
							"\n----------------------------------------------------------------\n");
						
					}
					
				}catch (IOException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	}
}
