package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class FrmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final String GUIproyecto = null;
	public static JLabel lblEstado;

	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("Img\\FlyMasterSmall.png"));
		getContentPane().setBackground(Color.WHITE);
		initialize();
	}

	private void initialize() {
		setBounds(100, 100, 600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 584, 21);
		getContentPane().add(menuBar);

		JMenu mnBase = new JMenu("Base");
		menuBar.add(mnBase);

		JMenuItem mntmProyectos = new JMenuItem("Proyectos");
		mntmProyectos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.CtrlProyectos.inicio();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
					e1.printStackTrace();
				}
			}
		});
		mnBase.add(mntmProyectos);
		JMenuItem mntmTrabajadores = new JMenuItem("Trabajadores");
		mntmTrabajadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.CtrlTrabajadores.inicio();
				} catch (SQLException e1) {
					System.out.println("Error al abrir trabajadores");
					e1.printStackTrace();
				}
			}
		});
		mnBase.add(mntmTrabajadores);

		JSeparator separator = new JSeparator();
		mnBase.add(separator);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		mnBase.add(mntmSalir);

		JMenu mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);

		JMenuItem mntmEquipos = new JMenuItem("Equipos");
		mntmEquipos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.CtrlEquipos.inicio();
			}
		});
		mnGestion.add(mntmEquipos);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("C:\\Users\\Alfonso\\Desktop\\Java\\Ind_Nostromo\\img\\Nostromo.jpg"));
		Logo.setBounds(38, 61, 500, 500);
		getContentPane().add(Logo);

		lblEstado = new JLabel("");
		lblEstado.setBounds(10, 32, 101, 27);
		getContentPane().add(lblEstado);
		setVisible(true);
	}
}
