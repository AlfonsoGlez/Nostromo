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
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\230pxCM_Seal.png"));
		initialize();
	}

	private void initialize() {
		setTitle("Trabajadores");
		setBounds(100, 100, 625, 465);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		getContentPane().setLayout(null);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setIcon(new ImageIcon("img\\anadir.png"));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrlTrabajadores.crearNuevoTrabajador();
			}
		});
		btnNuevo.setBounds(10, 356, 115, 33);
		getContentPane().add(btnNuevo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.setIcon(new ImageIcon("img\\borrar.png"));
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
		btnBorrar.setBounds(162, 356, 115, 33);
		getContentPane().add(btnBorrar);

		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon("img\\editar.png"));
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
		btnEditar.setBounds(327, 356, 115, 33);
		getContentPane().add(btnEditar);

		JButton btnInfo = new JButton("Info");
		btnInfo.setIcon(new ImageIcon("img\\info.png"));
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					controller.CtrlTrabajadores.infoTrabajador();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnInfo.setBounds(484, 356, 115, 33);
		getContentPane().add(btnInfo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(91, 31, 375, 268);
		getContentPane().add(scrollPane);

		tableTrabajador = new JTable();
		scrollPane.setViewportView(tableTrabajador);
		
				JLabel lblLogo = new JLabel("");
				lblLogo.setIcon(new ImageIcon("img\\NostromoSmall.jpg"));
				lblLogo.setBounds(469, 112, 130, 130);
				getContentPane().add(lblLogo);

		setVisible(true);

	}
}
