package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DiaParametros extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField txtIP;
	public static JTextField txtPuerto;
	public static JTextField txtNombreBaseDatos;
	public static JTextField txtUsuario;
	public static JPasswordField txtConta;

	public DiaParametros() {
		setModal(true);
		setBounds(100, 100, 320, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblDireccionIp = new JLabel("Direccion IP:");
			lblDireccionIp.setBounds(30, 28, 89, 14);
			contentPanel.add(lblDireccionIp);
		}

		txtIP = new JTextField();
		txtIP.setBounds(184, 25, 86, 20);
		contentPanel.add(txtIP);
		txtIP.setColumns(10);

		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(30, 64, 46, 14);
		contentPanel.add(lblPuerto);

		txtPuerto = new JTextField();
		txtPuerto.setBounds(184, 61, 86, 20);
		contentPanel.add(txtPuerto);
		txtPuerto.setColumns(10);

		JLabel lblNombreDeLa = new JLabel("Nombre de la Base de Datos:");
		lblNombreDeLa.setBounds(30, 95, 156, 14);
		contentPanel.add(lblNombreDeLa);

		txtNombreBaseDatos = new JTextField();
		txtNombreBaseDatos.setBounds(184, 92, 86, 20);
		contentPanel.add(txtNombreBaseDatos);
		txtNombreBaseDatos.setColumns(10);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(30, 130, 46, 14);
		contentPanel.add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(184, 123, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(30, 169, 89, 14);
		contentPanel.add(lblContrasea);

		txtConta = new JPasswordField();
		txtConta.setBounds(184, 166, 86, 20);
		contentPanel.add(txtConta);

		JButton btnConectar = new JButton("ESTABLECER CONEXION");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrPrincipal.probarConexion();
				dispose();
			}
		});
		btnConectar.setBounds(30, 227, 240, 23);
		contentPanel.add(btnConectar);

		setVisible(true);
	}
}
