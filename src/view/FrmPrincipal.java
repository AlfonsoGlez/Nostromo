package view;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;

import javax.help.HelpBroker;
import javax.help.HelpSet;
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
	public static JMenuItem menuItemHelp;

	public FrmPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\230px-CM_Seal.png"));
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
				try {
					controller.CtrlEquipos.inicio();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnGestion.add(mntmEquipos);

		JMenu Ayuda = new JMenu("Ayuda");
		menuBar.add(Ayuda);

		menuItemHelp = new JMenuItem("Abrir JavaHelp");
		Ayuda.add(menuItemHelp);

		JLabel Logo = new JLabel("");
		Logo.setIcon(new ImageIcon("img\\Nostromo.jpg"));
		Logo.setBounds(38, 61, 500, 500);
		getContentPane().add(Logo);

		lblEstado = new JLabel("");
		lblEstado.setBounds(10, 32, 101, 27);
		getContentPane().add(lblEstado);

		cargarAyuda();
		setVisible(true);
	}

	public void cargarAyuda() {
		try {
			// Carga el fichero de ayuda
			File fichero = new File("proyecto/help/help.hs");
			URL hsURL = fichero.toURI().toURL();

			// Crea el HelpSet y el HelpBroker
			HelpSet helpset = new HelpSet(getClass().getClassLoader(), hsURL);
			HelpBroker hb = helpset.createHelpBroker();
			// Pone ayuda a item de menu al pulsar F1. mntmIndice es el JMenuitem
			hb.enableHelpOnButton(menuItemHelp, "manual", helpset);

		} catch (Exception e) {
			e.getMessage();
		}
	}
}
