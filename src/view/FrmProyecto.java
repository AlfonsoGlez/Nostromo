package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmProyecto extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable tableProyecto;

	public FrmProyecto() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\FlyMasterSmall.png"));
		initialize();
	}

	private void initialize() {
		setTitle("Proyectos");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 560, 465);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon("Img\\A\u00F1adir.png"));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setBounds(10, 382, 103, 33);
		getContentPane().add(btnNuevo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon("Img\\Borrar.png"));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBorrar.setBounds(152, 382, 103, 33);
		getContentPane().add(btnBorrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("Img\\Editar.png"));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditar.setBounds(288, 382, 103, 33);
		getContentPane().add(btnEditar);

		JButton btnInfo = new JButton("Info");
		btnInfo.setIcon(new ImageIcon("Img\\info.png"));
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInfo.setBounds(431, 382, 103, 33);
		getContentPane().add(btnInfo);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("Img\\FlyMasterSmall.png"));
		lblLogo.setBounds(414, 251, 120, 120);
		getContentPane().add(lblLogo);

		JScrollPane scrollPaneProyecto = new JScrollPane();
		scrollPaneProyecto.setBounds(85, 120, 354, 238);
		getContentPane().add(scrollPaneProyecto);

		tableProyecto = new JTable();
		scrollPaneProyecto.setViewportView(tableProyecto);

		setVisible(true);

	}

}