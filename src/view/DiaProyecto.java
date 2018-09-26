package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class DiaProyecto extends JDialog {

	private static final long serialVersionUID = 1L;

	public static JTextField textNombre;
	public static JTextField textPres;
	public static JTextField textFechaIn;
	public static JTextField textFechaFin;
	public static JButton buttonCambios;
	public static JButton btnGuardar;
	public static JLabel Nombre2;
	public static JLabel Presupuesto2;
	public static JLabel FechaInicio2;
	public static JLabel FechaFin2;

	public DiaProyecto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\FlyMasterSmall.png"));
		getContentPane().setBackground(Color.WHITE);
		initialize();
		controller.CtrlProyectos.rellenarCuadrosP();
		setVisible(true);
	}

	private void initialize() {

		setTitle("Proyecto detalle");
		setBounds(100, 100, 274, 272);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 70, 21);
		getContentPane().add(lblNewLabel);

		JLabel lblPresupuesto = new JLabel("Presupuesto");
		lblPresupuesto.setBounds(10, 43, 89, 21);
		getContentPane().add(lblPresupuesto);

		JLabel lblFechaInicio = new JLabel("Fecha inicio");
		lblFechaInicio.setBounds(10, 75, 70, 21);
		getContentPane().add(lblFechaInicio);

		JLabel lblFechaFin = new JLabel("Fecha fin");
		lblFechaFin.setBounds(10, 109, 70, 21);
		getContentPane().add(lblFechaFin);

		textNombre = new JTextField();
		textNombre.setBounds(114, 11, 86, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		textPres = new JTextField();
		textPres.setColumns(10);
		textPres.setBounds(114, 43, 86, 20);
		getContentPane().add(textPres);

		textFechaIn = new JTextField();
		textFechaIn.setColumns(10);
		textFechaIn.setBounds(114, 75, 86, 20);
		getContentPane().add(textFechaIn);

		textFechaFin = new JTextField();
		textFechaFin.setColumns(10);
		textFechaFin.setBounds(114, 109, 86, 20);
		getContentPane().add(textFechaFin);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("Img\\FlyMasterSmall.png"));
		lblLogo.setBounds(138, 113, 120, 120);
		getContentPane().add(lblLogo);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.CtrlProyectos.nuevoProyecto();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				controller.CtrlProyectos.rellenarProyecto();
				dispose();
			}
		});
		btnGuardar.setBounds(88, 192, 89, 30);
		getContentPane().add(btnGuardar);

		buttonCambios = new JButton("Guardar");
		buttonCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.CtrlProyectos.guardarProyecto();
					dispose();
					controller.CtrlProyectos.rellenarProyecto();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		buttonCambios.setBounds(88, 192, 89, 30);
		getContentPane().add(buttonCambios);

		Nombre2 = new JLabel("");
		Nombre2.setBounds(114, 11, 86, 21);
		getContentPane().add(Nombre2);

		Presupuesto2 = new JLabel("");
		Presupuesto2.setBounds(114, 43, 86, 21);
		getContentPane().add(Presupuesto2);

		FechaInicio2 = new JLabel("");
		FechaInicio2.setBounds(114, 75, 86, 21);
		getContentPane().add(FechaInicio2);

		FechaFin2 = new JLabel("");
		FechaFin2.setBounds(114, 109, 86, 21);
		getContentPane().add(FechaFin2);

	}

}
