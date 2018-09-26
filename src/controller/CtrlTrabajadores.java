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
import view.DiaTrabajador;

public class CtrlTrabajadores {

	public static List<Trabajador> lstTrabajador = new ArrayList<Trabajador>();
	public static int frameMode;
	public static Integer elementoSeleccionado;
	public static String coordenada;

	/**
	 * Abre la ventana donde se muestra la tabla de los registros de los
	 * trabajadores.
	 * 
	 * @throws SQLException
	 */
	public static void inicio() throws SQLException {
		new view.FrmTrabajador();
		ctrConsTrabajador();
		rellenarTrabajador();

	}

	/**
	 * Llama al metodo que hace la consulta a la tabla de trabajadores.
	 * 
	 * @throws SQLException
	 */
	public static void ctrConsTrabajador() throws SQLException {
		logic.LogicTrabajador.dbConsTrabajador();

	}

	/**
	 * Establecer una conexion y un canal con la base de datos para capturar los
	 * datos de los trabajadores para rellenar la tabla de la ventana de
	 * trabajadores con dichos datos.
	 */
	public static void rellenarTrabajador() {
		try {
			Connection c = databasemanager.DBsqlServer.establecerConexion();
			Statement s = c.createStatement();
			String strSQL = logic.LogicTrabajador.sqlTrabajador;
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

			view.FrmTrabajador.tableTrabajador.setModel(modelo);

			// cerrar la conexion
			databasemanager.DBsqlServer.cerrarConexion(c);

		} catch (Exception e) {

		}

	}

	/**
	 * Captura el dato que se encuentra en la fila y la columna correspondiente a la
	 * que se ha hecho click con el raton y llama al metodo encargado de borrar el
	 * registro seleccionado.
	 * 
	 * @throws SQLException
	 */
	public static void borrarTrabajador() throws SQLException {
		coordenada = (String) view.FrmTrabajador.tableTrabajador.getValueAt(
				view.FrmTrabajador.tableTrabajador.getSelectedRow(),
				view.FrmTrabajador.tableTrabajador.getSelectedColumn());
		logic.LogicTrabajador.dbBorrarTrabajador();

	}

	/**
	 * Captura el indice del trabajador que queremos editar y sustituir los datos
	 * antiguos por los nuevos a traves del metodo dbEditarTrabajador de la parte
	 * logica.
	 * 
	 * @throws SQLException
	 */
	public static void editarTrabajador() throws SQLException {
		coordenada = (String) view.FrmTrabajador.tableTrabajador.getValueAt(
				view.FrmTrabajador.tableTrabajador.getSelectedRow(),
				view.FrmTrabajador.tableTrabajador.getSelectedColumn());

		Trabajador t = logic.LogicTrabajador.dbEditarTrabajador(coordenada);
		view.DiaTrabajador dialogTrb = new view.DiaTrabajador();
		// rellenar los campos del cialogo...
		DiaTrabajador.textDNI.setText(t.getDNI());
		DiaTrabajador.textNombre.setText(t.getNombreT());
		DiaTrabajador.textApellidos.setText(t.getApellidos());
		DiaTrabajador.textGenero.setText(t.getSexo());
		dialogTrb.setModal(true);

	}

	/**
	 * Pasa los valores escritos en los cuadros de texto mediante parametros para su
	 * posterior guardado a la hora de editarlos en la base de datos.
	 * 
	 * @throws SQLException
	 */
	public static void guardarTrabajador() throws SQLException {
		String DniT = view.DiaTrabajador.textDNI.getText();
		String nombreT = view.DiaTrabajador.textNombre.getText();
		String apellidoT = view.DiaTrabajador.textApellidos.getText();
		String generoT = view.DiaTrabajador.textGenero.getText();

		Trabajador t = new Trabajador();
		t.setDNI(DniT);
		t.setNombreT(nombreT);
		t.setApellidos(apellidoT);
		t.setSexo(generoT);

		logic.LogicTrabajador.lgGuardarTrabajador(coordenada, t);

	}

	/**
	 * Muestra los datos del registro seleccionado de la tabla de proyectos para ver
	 * toda la informacion.
	 * 
	 * @throws SQLException
	 */
	public static void infoTrabajador() throws SQLException {
		coordenada = (String) view.FrmTrabajador.tableTrabajador.getValueAt(
				view.FrmTrabajador.tableTrabajador.getSelectedRow(),
				view.FrmTrabajador.tableTrabajador.getSelectedColumn());

		Trabajador t = logic.LogicTrabajador.dbEditarTrabajador(coordenada);
		view.DiaTrabajador dialogTrb = new view.DiaTrabajador();
		// rellenar los campos del cialogo...
		DiaTrabajador.lblDNI2.setText(t.getDNI());
		DiaTrabajador.lblNombre2.setText(t.getNombreT());
		DiaTrabajador.lblApellidos2.setText(t.getApellidos());
		DiaTrabajador.lblGenero2.setText(t.getSexo());
		DiaTrabajador.lblDNI2.setVisible(true);
		DiaTrabajador.lblNombre2.setVisible(true);
		DiaTrabajador.lblApellidos2.setVisible(true);
		DiaTrabajador.lblGenero2.setVisible(true);
		DiaTrabajador.textDNI.setVisible(false);
		DiaTrabajador.textNombre.setVisible(false);
		DiaTrabajador.textApellidos.setVisible(false);
		DiaTrabajador.textGenero.setVisible(false);
		DiaTrabajador.btnGuardar.setVisible(false);
		DiaTrabajador.btnGuardarNuevo.setVisible(false);
		dialogTrb.setModal(true);

	}

	/**
	 * Genera un nuevo cuadro de dialogo en el cual se pueden rellenar los campos de
	 * un nuevo trabajador para crearlo en la base de datos.
	 */
	public static void crearNuevoTrabajador() {
		view.DiaTrabajador dialogTrb = new view.DiaTrabajador();
		DiaTrabajador.btnGuardar.setVisible(false);

	}

	/**
	 * Metodo encargado de pasar a la logica los parametros con los valores del
	 * nuevo trabajador para incluirlo en la base de datos.
	 * 
	 * @throws SQLException
	 */
	public static void nuevoTrabajador() throws SQLException {
		String dniT = view.DiaTrabajador.textDNI.getText();
		String nombreT = view.DiaTrabajador.textNombre.getText();
		String apellidosT = view.DiaTrabajador.textApellidos.getText();
		String generoT = view.DiaTrabajador.textGenero.getText();

		logic.LogicTrabajador.lgNuevoTrabajador(dniT, nombreT, apellidosT, generoT);

	}

}
