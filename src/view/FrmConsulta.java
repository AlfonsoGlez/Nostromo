package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class FrmConsulta extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable table;
	public static JTextArea textAreaSQL;

	public FrmConsulta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 130, 355, 120);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		textAreaSQL = new JTextArea();
		textAreaSQL.setBounds(29, 38, 355, 55);
		contentPane.add(textAreaSQL);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrPrincipal.limpiarCuadroSQL();
			}
		});
		btnLimpiar.setBounds(101, 96, 89, 23);
		contentPane.add(btnLimpiar);

		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CtrPrincipal.ejercutarSentencia();
			}
		});
		btnEjecutar.setBounds(245, 96, 89, 23);
		contentPane.add(btnEjecutar);
		setVisible(true);
	}
}
