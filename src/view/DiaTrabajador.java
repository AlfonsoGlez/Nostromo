package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DiaTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;

	public static JTextField textDNI;
	public static JTextField textNombre;
	public static JTextField textApellidos;
	public static JTextField textGenero;
	public static JButton btnGuardar;
	public static JLabel lblDNI2;
	public static JLabel lblNombre2;
	public static JLabel lblApellidos2;
	public static JLabel lblGenero2;
	public static JButton btnGuardarNuevo;

	public DiaTrabajador() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("img\\230pxCM_Seal.png"));
		getContentPane().setBackground(Color.WHITE);
		initialize();
		setVisible(true);
	}

	private void initialize() {

		setTitle("Trabajador");
		setBounds(100, 100, 450, 310);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(10, 21, 70, 21);
		getContentPane().add(lblDNI);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 53, 89, 21);
		getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 85, 70, 21);
		getContentPane().add(lblApellidos);

		JLabel lblGenero = new JLabel("Genero:");
		lblGenero.setBounds(10, 121, 70, 21);
		getContentPane().add(lblGenero);

		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(90, 22, 151, 20);
		getContentPane().add(textDNI);

		textNombre = new JTextField();
		textNombre.setBounds(90, 54, 151, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(90, 85, 151, 20);
		getContentPane().add(textApellidos);

		textGenero = new JTextField();
		textGenero.setBounds(90, 121, 151, 20);
		getContentPane().add(textGenero);
		textGenero.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setIcon(new ImageIcon("img\\carpeta.png"));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					controller.CtrlTrabajadores.guardarTrabajador();
					controller.CtrlTrabajadores.rellenarTrabajador();
					dispose();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		btnGuardar.setBounds(114, 210, 127, 33);
		getContentPane().add(btnGuardar);

		lblDNI2 = new JLabel("");
		lblDNI2.setBounds(90, 21, 151, 21);
		getContentPane().add(lblDNI2);

		lblNombre2 = new JLabel("");
		lblNombre2.setBounds(90, 53, 151, 21);
		getContentPane().add(lblNombre2);

		lblApellidos2 = new JLabel("");
		lblApellidos2.setBounds(90, 85, 151, 21);
		getContentPane().add(lblApellidos2);

		lblGenero2 = new JLabel("");
		lblGenero2.setBounds(90, 121, 151, 21);
		getContentPane().add(lblGenero2);

		btnGuardarNuevo = new JButton("Guardar");
		btnGuardarNuevo.setIcon(new ImageIcon("img\\carpeta.png"));
		btnGuardarNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.CtrlTrabajadores.nuevoTrabajador();
					// dispose();
					controller.CtrlTrabajadores.rellenarTrabajador();
					dispose();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnGuardarNuevo.setBounds(114, 210, 111, 33);
		getContentPane().add(btnGuardarNuevo);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("img\\NostromoSmall.jpg"));
		lblLogo.setBounds(294, 64, 130, 130);
		getContentPane().add(lblLogo);

	}
}