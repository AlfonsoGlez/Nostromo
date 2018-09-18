package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class FrmEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JComboBox proyectoBox;
	static DefaultTableModel modelotabla;
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Create the application.
	 */
	public FrmEquipos() {

		initialize();
		setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\FlyMasterSmall.png"));

		setSize(450, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("Equipo");
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Proyecto");
		lblNewLabel.setBounds(59, 53, 43, 14);
		getContentPane().add(lblNewLabel);

		proyectoBox = new JComboBox();
		proyectoBox.setModel(new DefaultComboBoxModel());
		proyectoBox.setBounds(112, 50, 217, 20);
		getContentPane().add(proyectoBox);

		JButton nuevo = new JButton("Nuevo");
		nuevo.setBackground(new Color(204, 255, 255));
		nuevo.setIcon(new ImageIcon("Img\\Añadir.png"));
		nuevo.setBounds(10, 267, 107, 33);
		getContentPane().add(nuevo);

		JButton borrar = new JButton("Borrar");
		borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		borrar.setBackground(new Color(204, 255, 255));
		borrar.setIcon(new ImageIcon("Img\\Borrar.png"));
		borrar.setBounds(166, 267, 107, 33);
		getContentPane().add(borrar);

		JButton editar = new JButton("Editar");
		editar.setBackground(new Color(204, 255, 255));
		editar.setIcon(new ImageIcon("Img\\Editar.png"));
		editar.setBounds(317, 267, 107, 33);
		getContentPane().add(editar);

		JLabel lblicon = new JLabel("Icon");
		lblicon.setBounds(313, 146, 120, 120);
		lblicon.setIcon(new ImageIcon("Img\\FlyMasterSmall.png"));
		getContentPane().add(lblicon);

	}

}
