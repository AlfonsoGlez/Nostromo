package logic;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

public class LogicPrincipal {
	public static int valor;

	/**
	 * Pasa la consulta que se va a ejecutar.
	 * 
	 * @param strSQL
	 * @return
	 * @throws SQLException
	 */
	public static CachedRowSet consultaGenerica(String strSQL) throws SQLException {
		return databasemanager.DBsqlServer.consultaSQL(strSQL);
	}

	/**
	 * Llama al metodo que hace la consuta de proyectos.
	 * 
	 * @throws SQLException
	 */
	public static void lgConsProyecto() throws SQLException {
		logic.LogicProyecto.dbConsProyecto();

	}

	/**
	 * Llama al metodo que hace la consulta de equipos.
	 * 
	 * @throws SQLException
	 */
	public static void lgConsEquipo() throws SQLException {
		logic.logicEquipo.dbConsEquipo();

	}

}