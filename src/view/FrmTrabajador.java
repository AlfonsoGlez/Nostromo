package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrmTrabajador extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTable tableTrabajador;

	public FrmTrabajador() {
		getContentPane().setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\FlyMasterSmall.png"));
		initialize();
	}

	private void initialize() {
		setTitle("Trabajadores");
		setBounds(100, 100, 560, 465);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon("Img\\A\u00F1adir.png"));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNuevo.setBounds(27, 356, 99, 33);
		getContentPane().add(btnNuevo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon("Img\\Borrar.png"));
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					controller.CtrlTrabajadores.borrarTrabajador();
					controller.CtrlTrabajadores.rellenarTrabajador();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnBorrar.setBounds(162, 356, 97, 33);
		getContentPane().add(btnBorrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("Img\\Editar.png"));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					controller.CtrlTrabajadores.editarTrabajador();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEditar.setBounds(298, 356, 89, 33);
		getContentPane().add(btnEditar);

		JButton btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnInfo.setBounds(424, 356, 99, 33);
		getContentPane().add(btnInfo);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Img\\FlyMasterSmall.png"));
		lblNewLabel.setBounds(414, 218, 120, 120);
		getContentPane().add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 114, 352, 198);
		getContentPane().add(scrollPane);

		tableTrabajador = new JTable();
		scrollPane.setViewportView(tableTrabajador);

		setVisible(true);

	}
}
