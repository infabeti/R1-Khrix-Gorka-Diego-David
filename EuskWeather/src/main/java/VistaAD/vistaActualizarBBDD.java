package VistaAD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ContAD.ControladorConvertirJSONXML;
import ContAD.ControladorDescargarIndex;
import ContAD.ControladorDescargarPrincipales;
import ContAD.ControladorPrincipal;
import ContAD.ControladorVolcarEspaciosNaturales;
import ContAD.ControladorVolcarEstaciones;
import ContAD.ControladorVolcarInformacionMeteo;
import ContAD.ControladorVolcarMunicipios;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class vistaActualizarBBDD extends JFrame {

	private ControladorDescargarPrincipales contDP;
	private ControladorConvertirJSONXML contConvert;
	private ControladorDescargarIndex contDI;
	private ControladorVolcarMunicipios contVM;
	private ControladorVolcarEstaciones contVE;
	private ControladorVolcarEspaciosNaturales contVEN;
	private ControladorVolcarInformacionMeteo contVIM;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public vistaActualizarBBDD(ControladorPrincipal contP) {
		contDP = contP.contDP;
		contConvert = contP.contConvert;
		contDI = contP.contDI;
		contVM = contP.contVM;
		contVE = contP.contVE;
		contVEN = contP.contVEN;
		contVIM = contP.contVIM;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMensaje = new JLabel("New label");
		lblMensaje.setBounds(128, 103, 161, 14);
		contentPane.add(lblMensaje);
		lblMensaje.setVisible(false);
		
		JButton btnNewButton = new JButton("Actualizar Base de Datos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
				lblMensaje.setText("BASE DE DATOS ACTUALIZADA");
				lblMensaje.setVisible(true);
				contDP.descPrinciples();
				contConvert.convertirJsonXml();
				contDI.descargarIndex();
				contVM.volcarMunicipos();
				contVE.volcarEstaciones();
				contVEN.volcarEspNatur();
				contVIM.volcarInfor();
				
				//System.exit(0);
			}
		});
		btnNewButton.setBounds(100, 76, 214, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSalir = new JButton("APAGAR SERVIDOR");
		btnSalir.setBounds(100, 128, 214, 23);
		contentPane.add(btnSalir);
		
		
		btnSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Servidor apagado");
				System.exit(0);
			}
			
		});
	}
}
