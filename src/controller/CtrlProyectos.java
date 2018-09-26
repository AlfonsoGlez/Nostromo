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
import view.DiaProyecto;

/**
 * 
 * @author Alfonso
 *
 */
public class CtrlProyectos {

	public static List<Proyecto> lstProyecto = new ArrayList<Proyecto>();
	public static int frameMode;
	public static Integer elementoSeleccionado;
	public static String coordenada;

	/**
	 * Abre una nueva ventana y llama a los metodos necesarios que hacen que dicha
	 * ventana tenga sus elementos graficos rellenos con los datos de los Proyectos
	 * guardados en la base de datos.
	 * 
	 * @throws SQLException
	 */
	public static void inicio() throws SQLException {

		new view.FrmProyecto();
		ctrConsProyecto();
		rellenarProyecto();

	}

	/**
	 * Ejecuta el metodo lgConsProyecto
	 * 
	 * @throws SQLException
	 */
	public static void ctrConsProyecto() throws SQLException {
		logic.LogicPrincipal.lgConsProyecto();

	}

	/**
	 * Establecer una conexion y un canal con la base de datos para capturar los
	 * datos de los proyectos para rellenar la tabla de la ventana de proyectos con
	 * dichos datos.
	 */
	public static void rellenarProyecto() {
		try {
			Connection c = databasemanager.DBsqlServer.establecerConexion();
			Statement s = c.createStatement();
			String strSQL = logic.LogicProyecto.sqlProyecto;
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
			view.FrmProyecto.tableProyecto.setModel(modelo);
			databasemanager.DBsqlServer.cerrarConexion(c);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * Genera un nuevo cuadro de dialogo en el cual se pueden rellenar los campos de
	 * un nuevo proyecto para crearlo en la base de datos.
	 */
	public static void crearNuevoProyecto() {
		view.DiaProyecto dialogPro = new view.DiaProyecto();
		DiaProyecto.buttonCambios.setVisible(false);

	}

	/**
	 * Captura el dato que se encuentra en la fila y la columna correspondiente a la
	 * que se ha hecho click con el raton y llama al metodo encargado de borrar el
	 * registro seleccionado.
	 * 
	 * @throws SQLException
	 */
	public static void borrarProyecto() throws SQLException {
		coordenada = (String) view.FrmProyecto.tableProyecto.getValueAt(view.FrmProyecto.tableProyecto.getSelectedRow(),
				view.FrmProyecto.tableProyecto.getSelectedColumn());

		logic.LogicProyecto.dbBorrarProyecto();

	}

	/**
	 * metodo encargado de capturar el indice del proyecto que queremos editar y
	 * sustituir los datos antiguos por los nuevos a traves del metodo
	 * dbEditarProyecto de la parte logica.
	 * 
	 * @throws SQLException
	 */
	public static void editarProyecto() throws SQLException {
		coordenada = (String) view.FrmProyecto.tableProyecto.getValueAt(view.FrmProyecto.tableProyecto.getSelectedRow(),
				view.FrmProyecto.tableProyecto.getSelectedColumn());

		Proyecto p = logic.LogicProyecto.dbEditarProyecto(coordenada);

		view.DiaProyecto dialogPro = new view.DiaProyecto();
		// rellenar los campos del cialogo...

		DiaProyecto.textNombre.setText(p.getNombre());
		DiaProyecto.textPres.setText(p.getPresupuesto());
		DiaProyecto.textFechaIn.setText(p.getFechaInicio());
		DiaProyecto.textFechaFin.setText(p.getFechaFin());
		DiaProyecto.btnGuardar.setVisible(false);

		dialogPro.setModal(true);

	}

	/**
	 * Metodo encargado de mostrar los datos del registro seleccionado de la tabla
	 * de proyectos para ver toda la informacion.
	 * 
	 * @throws SQLException
	 */
	public static void infoProyecto() throws SQLException {

		coordenada = (String) view.FrmProyecto.tableProyecto.getValueAt(view.FrmProyecto.tableProyecto.getSelectedRow(),
				view.FrmProyecto.tableProyecto.getSelectedColumn());

		Proyecto p = logic.LogicProyecto.dbEditarProyecto(coordenada);
		view.DiaProyecto dialogPro = new view.DiaProyecto();
		// rellenar los campos del dialogo...
		DiaProyecto.Nombre2.setText(p.getNombre());
		DiaProyecto.Presupuesto2.setText(p.getPresupuesto());
		DiaProyecto.FechaInicio2.setText(p.getFechaInicio());
		DiaProyecto.FechaFin2.setText(p.getFechaFin());
		DiaProyecto.Nombre2.setVisible(true);
		DiaProyecto.Presupuesto2.setVisible(true);
		DiaProyecto.FechaInicio2.setVisible(true);
		DiaProyecto.FechaFin2.setVisible(true);
		DiaProyecto.textNombre.setVisible(false);
		DiaProyecto.textPres.setVisible(false);
		DiaProyecto.textFechaIn.setVisible(false);
		DiaProyecto.textFechaFin.setVisible(false);
		DiaProyecto.buttonCambios.setVisible(false);
		DiaProyecto.btnGuardar.setVisible(false);
		dialogPro.setModal(true);

	}

	/**
	 * Metodo encargado de rellerar los cuadros de texto del frame
	 */
	public static void rellenarCuadrosP() {
		view.DiaProyecto.textNombre.setText(logic.LogicProyecto.nombre);
		view.DiaProyecto.textPres.setText(logic.LogicProyecto.presupuesto);
		view.DiaProyecto.textNombre.setText(logic.LogicProyecto.fechaInicio);
		view.DiaProyecto.textNombre.setText(logic.LogicProyecto.fechaFin);

	}

	/**
	 * Metodo encargado de pasar los valores escritos en los cuadros de texto
	 * mediante parametros para su posterior guardado a la hora de editarlos en la
	 * base de datos.
	 * 
	 * @throws SQLException
	 */
	public static void guardarProyecto() throws SQLException {
		String nombreP = view.DiaProyecto.textNombre.getText();
		String presupuestoP = view.DiaProyecto.textPres.getText();
		String fechaInicioP = view.DiaProyecto.textFechaIn.getText();
		String fechafinP = view.DiaProyecto.textFechaFin.getText();

		logic.LogicProyecto.lgGuardarProyecto(coordenada, nombreP, presupuestoP, fechaInicioP, fechafinP);

	}

	/**
	 * Metodo encargado de pasar a la logica los parametros con los valores del
	 * nuevo proyecto para incluirlo en la base de datos.
	 * 
	 * @throws SQLException
	 */
	public static void nuevoProyecto() throws SQLException {
		String nombreP = view.DiaProyecto.textNombre.getText();
		String presupuestoP = view.DiaProyecto.textPres.getText();
		String fechaInicioP = view.DiaProyecto.textFechaIn.getText();
		String fechaFinP = view.DiaProyecto.textFechaFin.getText();

		logic.LogicProyecto.lgNuevoProyecto(nombreP, presupuestoP, fechaInicioP, fechaFinP);

	}

}
