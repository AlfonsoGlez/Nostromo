package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CtrPrincipal {

	public static void inicioApp() {

		new view.FrmPrincipal();

	}

	public static void mostrarDialogo() {

		new view.DiaParametros();

	}

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

	public static void limpiarCuadroSQL() {
		view.FrmConsulta.textAreaSQL.setText(null);

	}

	public static void ejercutarSentencia() {
		try {

			String strSQL = view.FrmConsulta.textAreaSQL.getText();
			CachedRowSet resultado = logic.LogicPrincipal.consultaGenerica(strSQL);

			DefaultTableModel m = utils.Gui.generarTabla(resultado);
			view.FrmConsulta.table.setModel(m);

		} catch (Exception e) {

		}

	}

	public static void ejercuarSentenciaORIGINAL() {
		try {
			// Establecer una conexión
			Connection c = databasemanager.DBsqlServer.establecerConexion();

			// preparar el canal de comunicaciones en esa conex.
			Statement s = c.createStatement();

			// mandar la sentencia SQL y recoger los datos
			String strSQL = view.FrmConsulta.textAreaSQL.getText();
			ResultSet r = s.executeQuery(strSQL);
			ResultSetMetaData md = r.getMetaData();

			// pintar la tabla
			int totalCampos = md.getColumnCount();

			DefaultTableModel modelo = new DefaultTableModel();
			for (int i = 1; i <= totalCampos; i++) {
				modelo.addColumn(md.getColumnName(i));
			}

			String[] campo = new String[totalCampos];

			while (r.next()) {
				for (int i = 1; i <= totalCampos; i++) {
					campo[i - 1] = r.getString(i);
				}
				modelo.addRow(campo);
			}

			view.FrmConsulta.table.setModel(modelo);

			// cerrar la conexion
			databasemanager.DBsqlServer.cerrarConexion(c);

		} catch (Exception e) {

		}

	}

}