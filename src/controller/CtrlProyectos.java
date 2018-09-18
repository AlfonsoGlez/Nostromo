package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Proyecto;

public class CtrlProyectos {

	public static List<Proyecto> lstProyecto = new ArrayList<Proyecto>();
	public static int frameMode;
	public static Integer elementoSeleccionado;

	public static void inicio() throws SQLException {
		if (lstProyecto.isEmpty()) {
			inicializaLista();
		}

		new view.FrmProyecto();
		ctrConsProyecto();
		rellenarProyecto();

	}

	public static void ctrConsProyecto() throws SQLException {

		logic.LogicPrincipal.lgConsProyecto();

	}

	public static void rellenarProyecto() {
		try {
			// Establecer una conexión
			Connection c = databasemanager.DBsqlServer.establecerConexion();

			// preparar el canal de comunicaciones en esa conex.
			Statement s = c.createStatement();

			// mandar la sentencia SQL y recoger los datos
			String strSQL = logic.LogicProyecto.sqlProyecto;
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

			view.FrmProyecto.tableProyecto.setModel(modelo);

			// cerrar la conexion
			databasemanager.DBsqlServer.cerrarConexion(c);

		} catch (Exception e) {

		}

	}

	private static void inicializaLista() {

		lstProyecto.add(new Proyecto("Primero", 10, "12", "31"));
		lstProyecto.add(new Proyecto("Segundo", 20, "12", "31"));
		lstProyecto.add(new Proyecto("Tercero", 30, "12", "31"));
		lstProyecto.add(new Proyecto("Cuarto", 40, "12", "31"));
		lstProyecto.add(new Proyecto("Quinto", 50, "12", "31"));
		lstProyecto.add(new Proyecto("Sexto", 60, "12", "31"));
		lstProyecto.add(new Proyecto("Septimo", 70, "12", "31"));

	}

	public static void mostrarFrmDetalles(int mode, Integer selectedIndex) {
		if (selectedIndex >= 0) {
			frameMode = mode;
			elementoSeleccionado = selectedIndex;
			new view.DiaProyecto();
		}

	}

	public static void borrar(int selectedIndex) {
		if (selectedIndex >= 0) {
			lstProyecto.remove(selectedIndex);
		}
	}

	public static void crear(String text1, String text2, String text3, String text4) {
		Proyecto p = new Proyecto(text1, Integer.parseInt(text2), text3, text4);
		lstProyecto.add(p);
	}

	public static void editar(String text1, String text2, String text3, String text4) {
		Proyecto p = new Proyecto(text1, Integer.parseInt(text2), text3, text4);
		lstProyecto.set(elementoSeleccionado, p);
	}

}
