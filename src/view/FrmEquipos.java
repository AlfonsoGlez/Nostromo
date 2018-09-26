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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmEquipos extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JComboBox<String> proyectoBox;
	public static DefaultTableModel modelotabla;
	public DefaultTableModel modelo = new DefaultTableModel();
	public static JTable tableEquipo;

	public FrmEquipos() {

		initialize();
		setVisible(true);

	}

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

		proyectoBox = new JComboBox<String>();
		proyectoBox.setModel(new DefaultComboBoxModel<String>());
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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 94, 217, 140);
		getContentPane().add(scrollPane);

		tableEquipo = new JTable();
		scrollPane.setViewportView(tableEquipo);

		JLabel lblicon = new JLabel("Icon");
		lblicon.setBounds(294, 132, 130, 130);
		lblicon.setIcon(new ImageIcon("C:\\Users\\Alfonso\\Desktop\\Java\\Ind_Nostromo\\img\\NostromoSmall.jpg"));
		getContentPane().add(lblicon);

	}
}
