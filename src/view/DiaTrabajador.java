package view;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DiaTrabajador extends JDialog {

	private static final long serialVersionUID = 1L;

	public static JTextField textDNI;
	public static JTextField textNombre;
	public static JTextField textApellidos;
	public static JTextField textGenero;

	public DiaTrabajador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\FlyMasterSmall.png"));
		getContentPane().setBackground(Color.WHITE);
		initialize();
		setVisible(true);
	}

	private void initialize() {

		setTitle("Proyecto detalle");
		setBounds(100, 100, 309, 308);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(10, 11, 70, 21);
		getContentPane().add(lblDNI);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 43, 89, 21);
		getContentPane().add(lblNombre);

		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(10, 75, 70, 21);
		getContentPane().add(lblApellidos);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(10, 109, 70, 21);
		getContentPane().add(lblGenero);

		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(90, 11, 151, 20);
		getContentPane().add(textDNI);

		textNombre = new JTextField();
		textNombre.setBounds(90, 43, 151, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textApellidos = new JTextField();
		textApellidos.setColumns(10);
		textApellidos.setBounds(90, 75, 151, 20);
		getContentPane().add(textApellidos);

		textGenero = new JTextField();
		textGenero.setBounds(90, 106, 151, 20);
		getContentPane().add(textGenero);
		textGenero.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					controller.CtrlTrabajadores.guardarTrabajador();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		btnGuardar.setBounds(90, 210, 111, 33);
		getContentPane().add(btnGuardar);

		/*
		 * if (controller.CtrlTrabajadores.frameMode == 1) { JButton btnCrear = new
		 * JButton("CREAR"); btnCrear.setIcon(new ImageIcon("Img\\Aceptar.png"));
		 * btnCrear.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent arg0) {
		 * controller.CtrlTrabajadores.crear(textDNI.getText(), textNombre.getText(),
		 * textApellidos.getText(), (Genero) generoBox.getSelectedItem()); dispose(); }
		 * }); btnCrear.setBounds(26, 181, 101, 23); getContentPane().add(btnCrear); }
		 */

		/*
		 * if (controller.CtrlTrabajadores.frameMode == 2) { JButton btnGuardarCambios =
		 * new JButton("GUARDAR"); btnGuardarCambios.addActionListener(new
		 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
		 * controller.CtrlTrabajadores.editar(textDNI.getText(), textNombre.getText(),
		 * textApellidos.getText(), (Genero) generoBox.getSelectedItem()); dispose(); }
		 * 
		 * }); btnGuardarCambios.setBounds(26, 181, 101, 23);
		 * getContentPane().add(btnGuardarCambios); }
		 */

	}
}