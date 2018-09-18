package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	/**
	 * Create the application.
	 */
	public DiaProyecto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\FlyMasterSmall.png"));
		getContentPane().setBackground(Color.WHITE);
		initialize();
		if (controller.CtrlProyectos.frameMode != 1) {
			rellenarCuadros(); // sólo se rellenan los cuadros si es distinto de nuevo (Edit e Info)
			textNombre.setEnabled(controller.CtrlProyectos.frameMode == 2);
			textPres.setEnabled(controller.CtrlProyectos.frameMode == 2);
			textFechaIn.setEnabled(controller.CtrlProyectos.frameMode == 2);
			textFechaFin.setEnabled(controller.CtrlProyectos.frameMode == 2);
		}

		setVisible(true);
	}

	private void rellenarCuadros() {
		textNombre.setText(
				controller.CtrlProyectos.lstProyecto.get(controller.CtrlProyectos.elementoSeleccionado).getNombre());
		textPres.setText(controller.CtrlProyectos.lstProyecto.get(controller.CtrlProyectos.elementoSeleccionado)
				.getPresupuesto().toString());
		textFechaIn.setText(controller.CtrlProyectos.lstProyecto.get(controller.CtrlProyectos.elementoSeleccionado)
				.getFechaInicio());
		textFechaFin.setText(
				controller.CtrlProyectos.lstProyecto.get(controller.CtrlProyectos.elementoSeleccionado).getFechaFin());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setModal(true);
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

		if (controller.CtrlProyectos.frameMode == 1) {
			JButton btnCrear = new JButton("CREAR");
			btnCrear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.CtrlProyectos.crear(textNombre.getText(), textPres.getText(), textFechaIn.getText(),
							textFechaFin.getText());
					dispose();
				}
			});
			btnCrear.setBounds(26, 181, 101, 23);
			getContentPane().add(btnCrear);
		}

		if (controller.CtrlProyectos.frameMode == 2) {
			JButton btnGuardarCambios = new JButton("GUARDAR CAMBIOS");
			btnGuardarCambios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					controller.CtrlProyectos.editar(textNombre.getText(), textPres.getText(), textFechaIn.getText(),
							textFechaFin.getText());
					dispose();
				}

			});
			btnGuardarCambios.setBounds(26, 181, 101, 23);
			getContentPane().add(btnGuardarCambios);
		}

	}

}