package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Equipo;
import model.Proyecto;

/**
 * 
 * @author Alfonso
 *
 */
public class CtrlEquipos {
	/**
	 * 
	 */
	public static List<Equipo> lstEquipo = new ArrayList<Equipo>();
	public static List<?> tablaBid[][];
	public static int frameMode;
	public static Integer elementoSeleccionado;

	/**
	 * El metodo inicio se encaraga de llamar a los metodos necesarios para empezar
	 * a utilizar la ventana que gestiona los equipos.
	 * 
	 * @throws SQLException
	 */
	public static void inicio() throws SQLException {
		new view.FrmEquipos();
		ctrlConsEquipo();
		rellenarEquipo();
		rellenarCombo();

	}

	/**
	 * El metodo rellenarCombo es el encargado de llamar al metodo encargado de
	 * capturar los datos de los proyectos y añadirlos al comboBox.
	 * 
	 * @throws SQLException
	 */
	private static void rellenarCombo() throws SQLException {
		List<Proyecto> lstProyecto = logic.LogicProyecto.getListaProyectos();
		for (Proyecto pAct : lstProyecto) {
			view.FrmEquipos.proyectoBox.addItem(pAct.getNombre());
		}

	}

	/**
	 * El metodo rellenarEquipo se encarga de establecer una conexion y capturar los
	 * datos de los equipos guardados en la base de datos y rellenar una tabla con
	 * los datos capturados para su posterior tratamiento.
	 */
	private static void rellenarEquipo() {
		try {
			Connection c = databasemanager.DBsqlServer.establecerConexion();
			Statement s = c.createStatement();
			String strSQL = logic.LogicEquipo.sqlEquipo;
			ResultSet r = s.executeQuery(strSQL);
			ResultSetMetaData md = r.getMetaData();
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
			view.FrmEquipos.tableEquipo.setModel(modelo);
			databasemanager.DBsqlServer.cerrarConexion(c);

		} catch (Exception e) {
			e.getMessage();
		}

	}

	/**
	 * EL metodo ctrlConsEquipo llama al metod lgConsEquipo
	 * 
	 * @throws SQLException
	 */
	private static void ctrlConsEquipo() throws SQLException {
		logic.LogicPrincipal.lgConsEquipo();
	}

}
