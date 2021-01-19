package EuskWeather;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaCliente extends JFrame{
	
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtNickname;
	private JTextField txtPassword;
	private String sql;
	private final int PUERTO = 5000;
	private final String IP = "localhost";
	private Socket cliente = null;
	private ObjectInputStream entrada = null;
	private ObjectOutputStream salida = null;
	
	public static void main(String[] args) {
		VentanaCliente vc = new VentanaCliente();
		vc.setVisible(true);
	}
	
	public VentanaCliente() {

			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("VER USUARIOS");
		btnBuscar.setBounds(10, 11, 127, 23);
		contentPane.add(btnBuscar);
		
		JButton btnModificar = new JButton("MODIFICAR DIRECCION");
		btnModificar.setBounds(319, 11, 162, 23);
		contentPane.add(btnModificar);
		
		JButton btnInsertar = new JButton("INSERTAR USUARIO");
		btnInsertar.setBounds(147, 11, 162, 23);
		contentPane.add(btnInsertar);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(298, 45, 23, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(298, 70, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setBounds(298, 95, 58, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setBounds(298, 120, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nickname:");
		lblNewLabel_4.setBounds(298, 145, 58, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password:");
		lblNewLabel_5.setBounds(298, 170, 58, 14);
		contentPane.add(lblNewLabel_5);
		
		txtId = new JTextField();
		txtId.setBounds(319, 42, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(354, 67, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(354, 92, 86, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(354, 117, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		txtNickname = new JTextField();
		txtNickname.setBounds(354, 142, 86, 20);
		contentPane.add(txtNickname);
		txtNickname.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(354, 167, 86, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 45, 278, 185);
		contentPane.add(textArea);
		
		try {
			
			cliente = new Socket(IP, PUERTO);	
			System.out.println("Conexion realizada con el servidor.");
			
			btnBuscar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub		
					sql = "select u from Usuarios u";
					Usuarios users = new Usuarios();
					try {
						entrada = new ObjectInputStream(cliente.getInputStream());
						salida = new ObjectOutputStream(cliente.getOutputStream());
						salida.writeObject(sql);
						
						users = (Usuarios) entrada.readObject();
						
						
						textArea.setText("ID:"+users.getIdUsuario() + " Nick: " + users.getNickUsuario());
						
					} catch (IOException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				}
			
			});
		
			btnInsertar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					sql = "INSERT INTO usuarios "
							+ "VALUES(" + txtId.getText() + ", '" + txtNombre.getText() + "', '" 
							+ txtDireccion.getText() + "', '" + txtCorreo.getText() + "', '"
							+ txtNickname.getText() + "', '" + txtPassword.getText() + "')";
						
				}
			
			});
		
			btnModificar.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					sql = "UPDATE usuarios SET direccion='" + txtDireccion.getText() + "' "
							+ "WHERE idUsuario=" + txtDireccion.getText();
				
				}
			
			});
		
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
