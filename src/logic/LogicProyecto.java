package logic;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import model.Proyecto;

public class LogicProyecto {

	public static String sqlProyecto;
	public static CachedRowSet consultaProyecto;
	public static String sqlBorrarProyecto;

	public static String nombre;
	public static String presupuesto;
	public static String fechaInicio;
	public static String fechaFin;

	/**
	 * Obtiene una lista de proyectos.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static List<Proyecto> getListaProyectos() throws SQLException {
		String strSQL = "SELECT * FROM AG_Proyecto";
		CachedRowSet resultado = databasemanager.DBsqlServer.consultaSQL(strSQL);
		List<Proyecto> lst = new ArrayList<Proyecto>();
		while (resultado.next()) {
			Proyecto p = new Proyecto();
			p.setNombre(resultado.getString("Nombre"));
			p.setPresupuesto(resultado.getString("Presupuesto"));
			p.setFechaInicio(resultado.getString("FechaDeInicio"));
			p.setFechaFin(resultado.getString("FechaDeFin"));
			lst.add(p);
		}
		return lst;
	}

	/**
	 * Genera la consulta Select para toda la tabla proyecto.
	 * 
	 * @throws SQLException
	 */
	public static void dbConsProyecto() throws SQLException {

		sqlProyecto = "SELECT*FROM AG_Proyecto";
		consultaProyecto = logic.LogicPrincipal.consultaGenerica(sqlProyecto);
	}

	/**
	 * Genera el Delete para la tabla proyecto.
	 * 
	 * @throws SQLException
	 */
	public static void dbBorrarProyecto() throws SQLException {
		sqlBorrarProyecto = "delete from AG_Proyecto where ID_Proyecto=" + controller.CtrlProyectos.coordenada;
		databasemanager.DBsqlServer.ejecutarDML(sqlBorrarProyecto);

	}

	/**
	 * Genera la consulta Select para capturar los datos a editar en la tabla
	 * proyecto.
	 * 
	 * @param coord
	 * @return
	 * @throws SQLException
	 */
	public static Proyecto dbEditarProyecto(String coord) throws SQLException {
		String strSQL = "SELECT * FROM AG_Proyecto WHERE ID_Proyecto=" + coord;
		CachedRowSet resultado = logic.LogicPrincipal.consultaGenerica(strSQL);
		resultado.next();
		Proyecto p = new Proyecto();
		p.setNombre(resultado.getString("Nombre"));
		p.setPresupuesto(resultado.getString("Presupuesto"));
		p.setFechaInicio(resultado.getString("FechaDeInicio"));
		p.setFechaFin(resultado.getString("FechaDeFin"));

		return p;

	}

	/**
	 * Genera el Update para la tabla proyecto.
	 * 
	 * @param coord
	 * @param nombre
	 * @param presupuesto
	 * @param fechaInicio
	 * @param fechaFin
	 * @throws SQLException
	 */
	public static void lgGuardarProyecto(String coord, String nombre, String presupuesto, String fechaInicio,
			String fechaFin) throws SQLException {

		String strSQL = "update  AG_Proyecto set Nombre='" + nombre + "',Presupuesto='" + presupuesto
				+ "',FechaDeInicio='" + fechaInicio + "',FechaDeFin='" + fechaFin + "' WHERE ID_Proyecto=" + coord;
		databasemanager.DBsqlServer.ejecutarDML(strSQL);

	}

	/**
	 * Genera el Insert para la tabla proyecto.
	 * 
	 * @param nombre
	 * @param presupuesto
	 * @param fechaInicio
	 * @param fechaFin
	 * @throws SQLException
	 */
	public static void lgNuevoProyecto(String nombre, String presupuesto, String fechaInicio, String fechaFin)
			throws SQLException {
		String strSQL = "insert into   AG_Proyecto values ('" + nombre + "','" + presupuesto + "','" + fechaInicio
				+ "','" + fechaFin + "')";

		databasemanager.DBsqlServer.ejecutarDML(strSQL);

	}

}
