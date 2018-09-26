package controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CtrPrincipal {

	/**
	 * Inicia la ventana principal de la aplicacion
	 */
	public static void inicioApp() {
		new view.FrmPrincipal();

	}

	/**
	 * Abre un cuadro de dialogo para introducir los parametros de conexion en caso
	 * de que sea necesario.
	 */
	public static void mostrarDialogo() {
		new view.DiaParametros();

	}

	/**
	 * Prueba la conexion y te indica si esta conectado o no
	 */
	public static void probarConexion() {
		databasemanager.DBsqlServer.crearCadenaConexion(view.DiaParametros.txtIP.getText(),
				view.DiaParametros.txtPuerto.getText(), view.DiaParametros.txtNombreBaseDatos.getText(),
				view.DiaParametros.txtUsuario.getText(), String.valueOf(view.DiaParametros.txtConta.getPassword()));

		try {
			Connection c = databasemanager.DBsqlServer.establecerConexion();
			databasemanager.DBsqlServer.cerrarConexion(c);
			JOptionPane.showMessageDialog(null, "Conectado.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No conectado.");
		}

	}

}