package aaa;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;

public class VentanaConsultas extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public VentanaConsultas() {
		getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(21, 68, 258, 182);
		getContentPane().add(textArea);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Buscar todos los datos");
		rdbtnNewRadioButton.setBounds(16, 23, 133, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("modificar telefono");
		rdbtnNewRadioButton_1.setBounds(168, 23, 111, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Insertar Usuario");
		rdbtnNewRadioButton_2.setBounds(304, 23, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Ejecutar");
		btnNewButton.setBounds(314, 53, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(324, 93, 46, 14);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(317, 112, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion");
		lblNewLabel_1.setBounds(316, 139, 54, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(316, 164, 86, 20);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono");
		lblNewLabel_2.setBounds(324, 195, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(316, 212, 86, 20);
		getContentPane().add(textField_2);
	}
}
