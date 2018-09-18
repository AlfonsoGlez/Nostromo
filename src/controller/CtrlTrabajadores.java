package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Trabajador;

public class CtrlTrabajadores {

	public static List<Trabajador> lstTrabajador = new ArrayList<Trabajador>();
	public static int frameMode;
	public static Integer elementoSeleccionado;
	public static String coordenada;

	public static void inicio() throws SQLException {

		new view.FrmTrabajador();
		ctrConsTrabajador();
		rellenarTrabajador();

	}

	public static void ctrConsTrabajador() throws SQLException {

		logic.LogicTrabajador.dbConsTrabajador();

	}

	public static void rellenarTrabajador() {
		try {
			// Establecer una conexión
			Connection c = databasemanager.DBsqlServer.establecerConexion();

			// preparar el canal de comunicaciones en esa conex.
			Statement s = c.createStatement();

			// mandar la sentencia SQL y recoger los datos
			String strSQL = logic.LogicTrabajador.sqlTrabajador;
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

			view.FrmTrabajador.tableTrabajador.setModel(modelo);

			// cerrar la conexion
			databasemanager.DBsqlServer.cerrarConexion(c);

		} catch (Exception e) {

		}

	}

	public static void borrarTrabajador() throws SQLException {

		coordenada = (String) view.FrmTrabajador.tableTrabajador.getValueAt(
				view.FrmTrabajador.tableTrabajador.getSelectedRow(),
				view.FrmTrabajador.tableTrabajador.getSelectedColumn());
		logic.LogicTrabajador.dbBorrarTrabajador();

	}

	public static void editarTrabajador() throws SQLException {

		coordenada = (String) view.FrmTrabajador.tableTrabajador.getValueAt(
				view.FrmTrabajador.tableTrabajador.getSelectedRow(),
				view.FrmTrabajador.tableTrabajador.getSelectedColumn());

		Trabajador t = logic.LogicTrabajador.dbEditarTrabajador(coordenada);
		view.DiaTrabajador dialogTrb = new view.DiaTrabajador();
		// rellenar los campos del cialogo...
		dialogTrb.textDNI.setText(t.getDNI());
		dialogTrb.textNombre.setText(t.getNombreT());
		dialogTrb.textApellidos.setText(t.getApellidos());
		dialogTrb.textGenero.setText(t.getSexo());
		dialogTrb.setModal(true);

	}

	public static void guardarTrabajador() throws SQLException {

		String DniT = view.DiaTrabajador.textDNI.getText();
		String nombreT = view.DiaTrabajador.textNombre.getText();
		String apellidoT = view.DiaTrabajador.textApellidos.getText();
		String generoT = view.DiaTrabajador.textGenero.getText();

		logic.LogicTrabajador.lgGuardarTrabajador(coordenada, DniT, nombreT, apellidoT, generoT);

	}

}
